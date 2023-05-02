package com.argus.ems.master.service.impl.validation;

import com.argus.ems.common.constant.Constant;
import com.argus.ems.common.constant.ErrorLevel;
import com.argus.ems.common.dto.info.ContextInfo;
import com.argus.ems.common.dto.info.ValidationResultInfo;
import com.argus.ems.common.exceptioncontroller.exception.DataValidationErrorException;
import com.argus.ems.common.exceptioncontroller.exception.DoesNotExistException;
import com.argus.ems.common.exceptioncontroller.exception.InvalidParameterException;
import com.argus.ems.common.exceptioncontroller.exception.MissingParameterException;
import com.argus.ems.common.exceptioncontroller.exception.OperationFailedException;
import com.argus.ems.common.exceptioncontroller.exception.PermissionDeniedException;
import com.argus.ems.common.exceptioncontroller.exception.VersionMismatchException;
import com.argus.ems.common.utils.ValidationUtils;
import com.argus.ems.master.dto.info.TypeInfo;
import com.argus.ems.master.service.contract.TypeService;
import com.argus.ems.master.service.contract.TypeServiceBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.CollectionUtils;

@Service
public class TypeServiceValidationImpl extends TypeServiceBaseImpl implements TypeService {

    public static final String REF_OBJECT_URI = "refObjectUri";

    @Autowired
    @Qualifier("typeServiceImpl")
    TypeService typeService;

    @PostConstruct
    public void setNextDecorator() {
        super.setNextDecorator(typeService);
    }

//     @Override
//    @Timed(name = "getRevisions")
//    public Page<TypeInfo> getRevisions(
//            RevisionSearchFilter searchFilter,
//            Pageable pageable,
//            ContextInfo contextInfo)
//            throws OperationFailedException,
//            MissingParameterException,
//            PermissionDeniedException,
//            InvalidParameterException {
//        return typeService.getRevisions(searchFilter, pageable, contextInfo);
//    }
    
    
      
    @Override
    public Page<TypeInfo> searchTypesByRefObjectUriAndName(
            List<String> ids,
            String stateId,
            String refObjectUri,
            String name,
            Pageable pageable, ContextInfo contextInfo)
            throws DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException {

        System.out.println(ids);
        System.out.println(CollectionUtils.isEmpty(ids));
        System.out.println(StringUtils.isEmpty(refObjectUri));
        if (CollectionUtils.isEmpty(ids) && StringUtils.isEmpty(refObjectUri)) {
            
//            throw new MissingParameterException("refObjectUri is missing");
        }
        return typeService.searchTypesByRefObjectUriAndName(
                ids,
                stateId,
                refObjectUri,
                name,
                pageable,
                contextInfo);
    }
        
    @Override
    public TypeInfo createType(
            TypeInfo typeInfo,
            String refObjectUri,
            ContextInfo contextInfo)
            throws OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException,
            DataValidationErrorException {
        if (typeInfo == null) {
            throw new MissingParameterException("Type is missing");
        }
        // CREATE
        List<ValidationResultInfo> validationResultInfos
                = this.validateType(Constant.CREATE_VALIDATION, typeInfo, refObjectUri, contextInfo);
        if (ValidationUtils.containsErrors(validationResultInfos, ErrorLevel.ERROR)) {
            throw new DataValidationErrorException("Error(s) occurred validating",
                    validationResultInfos);
        }
        System.out.println("---------------------validation done------------------");
        return typeService.createType(typeInfo, refObjectUri, contextInfo);
    }

    /**
     * {@inheritdoc}
     */
    public TypeInfo updateState(TypeInfo typeInfo, ContextInfo contextInfo)
            throws DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException,
            VersionMismatchException,
            DataValidationErrorException {
        if (typeInfo == null) {
            throw new MissingParameterException("State is missing");
        }
       
        return typeService.updateType(typeInfo, contextInfo);
    }


    @Override
    public TypeInfo getTypeById(String typeId, ContextInfo contextInfo)
            throws DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException {
        if (StringUtils.isEmpty(typeId)) {
            throw new MissingParameterException("id is missing");
        }
        return typeService.getTypeById(typeId, contextInfo);
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public List<ValidationResultInfo> validateType(
            String validationTypeKey,
            TypeInfo typeInfo,
            String refObjectUri,
            ContextInfo contextInfo)
            throws OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException {
        // VALIDATE
        List<ValidationResultInfo> errors = new ArrayList<>();
        TypeInfo originalInfo = null;
        trimType(typeInfo);

        // check Common Required
        this.validateCommonRequired(typeInfo, errors);

        // check Common ForeignKey
        this.validateCommonForeignKey(typeInfo, errors, contextInfo);

        // check Common Unique
        this.validateCommonUnique(typeInfo,
                validationTypeKey,
                errors,
                contextInfo);

        switch (validationTypeKey) {
            case Constant.UPDATE_VALIDATION:

                // get the info
                if (typeInfo.getId() != null) {
                    try {
                        originalInfo
                                = this.typeService.getTypeById(typeInfo.getId(),
                                        contextInfo);
                    } catch (DoesNotExistException ex) {
                        String fieldName = "id";
                        errors.add(new ValidationResultInfo(fieldName,
                                ErrorLevel.ERROR,
                                "The id supplied to the update does not exists"));
                    }
                }

                if (ValidationUtils.containsErrors(errors, ErrorLevel.ERROR)) {
                    return errors;
                }

                this.validateUpdateType(errors,
                        typeInfo,
                        originalInfo);
                break;
            case Constant.CREATE_VALIDATION:
                this.validateCreateType(errors, typeInfo, contextInfo);
                break;
            default:
                throw new InvalidParameterException("Invalid validationTypeKey");
        }

        // For :Unique Id
        validateTypeInfoId(typeInfo,
                errors);
        // For :StateId
        validateTypeInfoStateId(typeInfo,
                errors);
        // For :Unique Icon
        validateTypeInfoIcon(typeInfo,
                originalInfo,
                validationTypeKey,
                errors,
                contextInfo);
        // For :Unique RefObjectUri
        validateTypeInfoRefObjectUri(typeInfo,
                refObjectUri,
                errors);
        // For :Unique EffectiveDates
        validateTypeInfoEffectiveDates(
                typeInfo,
                errors);
        // For :Name
        validateTypeInfoName(typeInfo,
                errors);
        // For :Description
        validateTypeInfoDescription(typeInfo,
                originalInfo,
                validationTypeKey,
                errors,
                contextInfo);
        // For :Meta
        validateTypeInfoMeta(typeInfo,
                originalInfo,
                validationTypeKey,
                errors,
                contextInfo);

        return errors;
    }

    protected void validateCommonForeignKey(TypeInfo typeInfo,
            List<ValidationResultInfo> errors,
            ContextInfo contextInfo)
            throws OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException {

    }

    //validate update
    protected void validateUpdateType(List<ValidationResultInfo> errors,
            TypeInfo typeInfo,
            TypeInfo originalInfo)
            throws OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException {
        // required validation
        ValidationUtils.validateRequired(
                typeInfo.getId(),
                "id",
                errors);
        //check the meta required
        if (ValidationUtils.metaIsEmpty(typeInfo.getMeta())) {
            String fieldName = "meta";
            errors.add(new ValidationResultInfo(fieldName,
                    ErrorLevel.ERROR,
                    fieldName + " must be provided"));
        }
       

        //refObjectUri can't be updatable
        ValidationUtils
                .validateNotUpdatable(
                        typeInfo.getRefObjectUri(),
                        originalInfo.getRefObjectUri(),
                        REF_OBJECT_URI,
                        errors);
    }

    //validate create
    protected void validateCreateType(List<ValidationResultInfo> errors,
            TypeInfo typeInfo,
            ContextInfo contextInfo)
            throws OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException {
        if (typeInfo.getId() != null) {
            try {
                this.typeService.getTypeById(typeInfo.getId(),
                        contextInfo);
                // if info found with same id than
                String fieldName = "id";
                errors.add(
                        new ValidationResultInfo(fieldName,
                                ErrorLevel.ERROR,
                                "The id supplied to the create already exists"));
            } catch (DoesNotExistException ex) {
                // This is ok becuase created id should be unique
            }
        }
        // check at a creation time meta should be null
        if (!ValidationUtils.metaIsEmpty(typeInfo.getMeta())) {
            String fieldName = "meta";
            errors.add(
                    new ValidationResultInfo(fieldName,
                            ErrorLevel.ERROR,
                            "no meta data should be supplied on a create"));
        }

    }

    //Validate Required
    protected void validateCommonRequired(TypeInfo typeInfo,
            List<ValidationResultInfo> errors) {
        //check the name required
        ValidationUtils
                .validateRequired(
                        typeInfo.getName(),
                        "name",
                        errors);
        //check the refObjectUri required
        ValidationUtils
                .validateRequired(
                        typeInfo.getRefObjectUri(),
                        REF_OBJECT_URI,
                        errors);
    }

    //Validate Common Unique
    protected void validateCommonUnique(TypeInfo typeInfo,
            String validationTypeKey,
            List<ValidationResultInfo> errors,
            ContextInfo contextInfo)
            throws OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException {

    }

    //Validation For :Id
    protected void validateTypeInfoId(TypeInfo typeInfo,
            List<ValidationResultInfo> errors) {
        ValidationUtils.validateNotEmpty(
                typeInfo.getId(),
                "id",
                errors);
    }

    //Validation For :StateId
    protected void validateTypeInfoStateId(TypeInfo typeInfo,
            List<ValidationResultInfo> errors) {
        // For :StateId
        // write validations that you want to validate for this field ...
    }

    //Validation For :Name
    protected void validateTypeInfoName(TypeInfo typeInfo,
            List<ValidationResultInfo> errors) {
        ValidationUtils.validatePattern(
                typeInfo.getName(),
                "name",
                Constant.ALLOWED_CHARS_IN_NAMES,
                "Only alphanumeric and " + Constant.ALLOWED_CHARS_IN_NAMES + " are allowed.",
                errors);
        ValidationUtils.validateLength(
                typeInfo.getName(),
                "name",
                3,
                Integer.MAX_VALUE,
                errors);
    }

    //Validation For :Description
    protected void validateTypeInfoDescription(TypeInfo typeInfo,
            TypeInfo originalInfo,
            String validationTypeKey,
            List<ValidationResultInfo> errors,
            ContextInfo contextInfo) {
        // For :Description
        // write validations that you want to validate for this field ...
    }

    //Validation For :Meta
    protected void validateTypeInfoMeta(TypeInfo typeInfo,
            TypeInfo originalInfo,
            String validationTypeKey,
            List<ValidationResultInfo> errors,
            ContextInfo contextInfo) {
        // For :Meta
        // write validations that you want to validate for this field ...
    }

    //Validation For :Icon
    protected void validateTypeInfoIcon(TypeInfo typeInfo,
            TypeInfo originalInfo,
            String validationTypeKey,
            List<ValidationResultInfo> errors,
            ContextInfo contextInfo) {
        // For :Icon
        // write validations that you want to validate for this field ...
    }

    //Validation For :Meta
    protected void validateTypeInfoRefObjectUri(
            TypeInfo typeInfo,
            String refObjectUri,
            List<ValidationResultInfo> errors) {
        ValidationUtils.validateLength(
                typeInfo.getRefObjectUri(),
                REF_OBJECT_URI,
                3,
                Integer.MAX_VALUE,
                errors);
        if (!StringUtils.isEmpty(refObjectUri)
                && !refObjectUri.equals(typeInfo.getRefObjectUri())) {
            String fieldName = REF_OBJECT_URI;
            errors.add(
                    new ValidationResultInfo(fieldName,
                            ErrorLevel.ERROR,
                            "refObjectUri in given request url and request body does not match."));
        }
    }

    //Validation For :EffectiveDates
    protected void validateTypeInfoEffectiveDates(
            TypeInfo typeInfo,
            List<ValidationResultInfo> errors) {
        ValidationUtils.validateEffectiveDates(
                typeInfo.getEffectiveDate(),
                typeInfo.getExpirationDate(),
                errors);
    }

    //trim all parish field
    protected void trimType(TypeInfo typeInfo) {
        if (typeInfo.getDescription() != null) {
            if (typeInfo.getDescription().getFormatted() != null) {
                typeInfo
                        .getDescription()
                        .setFormatted(typeInfo
                                .getDescription()
                                .getFormatted()
                                .trim());
            }
            if (typeInfo.getDescription().getPlain() != null) {
                typeInfo
                        .getDescription()
                        .setPlain(typeInfo
                                .getDescription()
                                .getPlain()
                                .trim());
            }
        }
        if (typeInfo.getId() != null) {
            typeInfo.setId(typeInfo.getId().trim());
        }
        if (typeInfo.getName() != null) {
            typeInfo.setName(typeInfo.getName().trim());
        }

        if (typeInfo.getRefObjectUri() != null) {
            typeInfo.setRefObjUri(typeInfo.getRefObjectUri().trim());
        }

    }

    public TypeInfo deleteType(String typeId, ContextInfo contextInfo)
            throws DoesNotExistException,
            DataValidationErrorException, InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException,
            VersionMismatchException {

        return typeService.deleteType(typeId, contextInfo);
    }
    
    

    
}
