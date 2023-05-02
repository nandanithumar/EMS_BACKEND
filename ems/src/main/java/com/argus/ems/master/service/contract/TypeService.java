
package com.argus.ems.master.service.contract;

import com.argus.ems.common.dto.info.ContextInfo;
import com.argus.ems.common.dto.info.ValidationResultInfo;
import com.argus.ems.common.exceptioncontroller.exception.DataValidationErrorException;
import com.argus.ems.common.exceptioncontroller.exception.DoesNotExistException;
import com.argus.ems.common.exceptioncontroller.exception.InvalidParameterException;
import com.argus.ems.common.exceptioncontroller.exception.MissingParameterException;
import com.argus.ems.common.exceptioncontroller.exception.OperationFailedException;
import com.argus.ems.common.exceptioncontroller.exception.PermissionDeniedException;
import com.argus.ems.common.exceptioncontroller.exception.VersionMismatchException;
import com.argus.ems.master.dto.info.TypeInfo;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeService {

   /*Comment for testing*/
    public TypeInfo createType(
            TypeInfo typeInfo,
            String refObjUri,
            ContextInfo contextInfo)
            throws OperationFailedException,
            InvalidParameterException,
            MissingParameterException,
            PermissionDeniedException,
            DataValidationErrorException;

    public TypeInfo updateType(
            TypeInfo typeInfo,
            ContextInfo contextInfo)
            throws DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            VersionMismatchException,
            DataValidationErrorException,
            InvalidParameterException;

              
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
            InvalidParameterException;

    
    public TypeInfo deleteType(String typeId,
            ContextInfo contextInfo)
            throws DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            VersionMismatchException,
            DataValidationErrorException,
            InvalidParameterException;

     public Page<TypeInfo> getAllTypes(TypeInfo typeInfo,Pageable pageable,ContextInfo contextInfo)
            throws DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException;
   
    
    public List<ValidationResultInfo> validateType(
            String validationTypeKey,
            TypeInfo typeInfo,
            String refObjectUri,
            ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException;

    
    public TypeInfo getTypeById(String typeId, ContextInfo contextInfo)
            throws DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException;
    
    
//        public Page<TypeInfo> getRevisions(
//            RevisionSearchFilter searchFilter,
//            Pageable pageable,
//            ContextInfo contextInfo)
//            throws OperationFailedException,
//            MissingParameterException,
//            PermissionDeniedException,
//            InvalidParameterException;

}
