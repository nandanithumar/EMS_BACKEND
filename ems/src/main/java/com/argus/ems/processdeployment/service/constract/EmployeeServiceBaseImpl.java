//package com.argus.ems.processdeployment.service.constract;
//
//import com.argus.ems.master.service.contract.*;
//import com.argus.ems.common.dto.info.ContextInfo;
//import com.argus.ems.common.dto.info.ValidationResultInfo;
//import com.argus.ems.common.exceptioncontroller.exception.DataValidationErrorException;
//import com.argus.ems.common.exceptioncontroller.exception.DoesNotExistException;
//import com.argus.ems.common.exceptioncontroller.exception.InvalidParameterException;
//import com.argus.ems.common.exceptioncontroller.exception.MissingParameterException;
//import com.argus.ems.common.exceptioncontroller.exception.OperationFailedException;
//import com.argus.ems.common.exceptioncontroller.exception.PermissionDeniedException;
//import com.argus.ems.common.exceptioncontroller.exception.VersionMismatchException;
//import com.argus.ems.master.dto.info.TypeInfo;
//import java.util.List;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
//public class EmployeeServiceBaseImpl implements TypeService {
//
//    TypeService typeService;
//
//    public void setNextDecorator(TypeService typeService) {
//        this.typeService = typeService;
//    }
//
//    @Override
//    public TypeInfo createType(TypeInfo typeInfo, String refObjectUri, ContextInfo contextInfo) throws OperationFailedException, InvalidParameterException, MissingParameterException, PermissionDeniedException, DataValidationErrorException {
//        return typeService.createType(typeInfo, refObjectUri, contextInfo);
//    }
//
//
//    @Override
//    public List<ValidationResultInfo> validateType(String validationTypeKey, TypeInfo typeInfo, String refObjectUri, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
//        return typeService.validateType(validationTypeKey, typeInfo, refObjectUri, contextInfo);
//    }
//    
//    @Override
//    public Page<TypeInfo> searchTypesByRefObjectUriAndName(List<String> ids, String stateId, String refObjectUri, String name, Pageable pageable, ContextInfo contextInfo) throws DoesNotExistException, OperationFailedException, MissingParameterException, PermissionDeniedException, InvalidParameterException {
//        return typeService.searchTypesByRefObjectUriAndName(ids, stateId, refObjectUri, name, pageable, contextInfo);
//    }
//
//    
//    @Override
//    public TypeInfo getTypeById(String typeId, ContextInfo contextInfo) throws DoesNotExistException, OperationFailedException, MissingParameterException, PermissionDeniedException, InvalidParameterException {
//        return typeService.getTypeById(typeId, contextInfo);
//    }
//
//    @Override
//    public TypeInfo deleteType(String typeId, ContextInfo contextInfo) throws DoesNotExistException, OperationFailedException, MissingParameterException, PermissionDeniedException, VersionMismatchException, DataValidationErrorException, InvalidParameterException {
//        return typeService.deleteType(typeId, contextInfo);
//    }
//
//    @Override
//    public TypeInfo updateType(TypeInfo typeInfo, ContextInfo contextInfo) throws DoesNotExistException, OperationFailedException, MissingParameterException, PermissionDeniedException, VersionMismatchException, DataValidationErrorException, InvalidParameterException {
//        return typeService.updateType(typeInfo, contextInfo);
//    }
//
//    @Override
//    public Page<TypeInfo> getAllTypes(TypeInfo typeInfo,Pageable pageable,ContextInfo contextInfo) throws DoesNotExistException, OperationFailedException, MissingParameterException, PermissionDeniedException, InvalidParameterException {
//        return typeService.getAllTypes(typeInfo, pageable,contextInfo);
//    }
//
//
//
//}
