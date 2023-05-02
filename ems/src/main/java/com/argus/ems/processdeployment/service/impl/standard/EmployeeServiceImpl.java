///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.argus.ems.processdeployment.service.impl.standard;
//
//import com.argus.ems.master.service.impl.standard.*;
//import com.argus.ems.common.constant.Constant;
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
//import com.argus.ems.master.service.contract.TypeService;
//import com.argus.ems.master.service.contract.TypeServiceBaseImpl;
//import com.argus.ems.master.service.impl.dao.TypeServiceDaoImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.StringUtils;
//
//import java.util.List;
//import javax.annotation.PostConstruct;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
///**
// * This TypeServiceImpl is for standard implementation for type service.
// *
// * @author akshar
// * @since 2021-2-17
// */
//@Service
//public class EmployeeServiceImpl extends TypeServiceBaseImpl implements TypeService {
//
//    @Autowired
//    TypeServiceDaoImpl typeServiceDao;
//
//    @PostConstruct
//    public void setNextDecorator() {
//        super.setNextDecorator(typeServiceDao);
//    }
//
//
//    /**
//     * {@inheritdoc}
//     */
//    @Override
//    @Transactional(rollbackFor = {
//        DoesNotExistException.class,
//        OperationFailedException.class,
//        MissingParameterException.class,
//        PermissionDeniedException.class,
//        InvalidParameterException.class,
//        VersionMismatchException.class,
//        DataValidationErrorException.class
//    })
//    public TypeInfo createType(
//            TypeInfo typeInfo,
//            String refObjectUri,
//            ContextInfo contextInfo)
//            throws OperationFailedException,
//            MissingParameterException,
//            PermissionDeniedException,
//            InvalidParameterException,
//            DataValidationErrorException {
//        System.out.println(typeInfo);
//        if (StringUtils.isEmpty(typeInfo.getId())) {
//
//            String id = Constant.TYPE_ID_PRIFIX
//                    + typeInfo.getRefObjectUri().toLowerCase()
//                    + Constant.DOT
//                    + typeInfo.getName().replaceAll("\\s", "").toLowerCase();
//
//            typeInfo.setId(id);
//        }
//        System.out.println(typeInfo);
//        System.out.println(typeServiceDao.createType(typeInfo, refObjectUri, contextInfo));
//        return typeServiceDao.createType(typeInfo, refObjectUri, contextInfo);
//    }
//
//    /**
//     * {@inheritdoc}
//     */
//    public TypeInfo updatetype(TypeInfo typeInfo, ContextInfo contextInfo)
//            throws DoesNotExistException,
//            OperationFailedException,
//            MissingParameterException,
//            PermissionDeniedException,
//            InvalidParameterException,
//            VersionMismatchException,
//            DataValidationErrorException {
//        return typeServiceDao.updateType(typeInfo, contextInfo);
//    }
//
//
//    /**
//     * {@inheritdoc}
//     */
//    @Override
//    public TypeInfo getTypeById(String typeId, ContextInfo contextInfo)
//            throws DoesNotExistException,
//            OperationFailedException,
//            MissingParameterException,
//            PermissionDeniedException,
//            InvalidParameterException {
//        return typeServiceDao.getTypeById(typeId, contextInfo);
//    }
//
//    
//    @Override
//    public TypeInfo deleteType(String typeId, ContextInfo contextInfo)
//            throws DoesNotExistException,
//            OperationFailedException,
//            MissingParameterException,
//            PermissionDeniedException,
//            InvalidParameterException {
//        return typeServiceDao.deleteType(typeId, contextInfo);
//    }
//    /**
//     * {@inheritdoc}
//     */
//    @Override
//    public List<ValidationResultInfo> validateType(
//            String validationTypeKey,
//            TypeInfo typeInfo,
//            String refObjectUri,
//            ContextInfo contextInfo)
//            throws DoesNotExistException,
//            InvalidParameterException,
//            MissingParameterException,
//            OperationFailedException,
//            PermissionDeniedException {
//        return typeServiceDao.validateType(validationTypeKey, typeInfo, refObjectUri, contextInfo);
//    }
//    
//    public Page<TypeInfo> getAllTypes(TypeInfo typeInfo, Pageable pageable,
//            ContextInfo contextInfo)
//            throws DoesNotExistException,
//            InvalidParameterException,
//            MissingParameterException,
//            OperationFailedException,
//            PermissionDeniedException {
//        return typeServiceDao.getAllTypes(typeInfo, pageable,contextInfo);
//    } 
//    
////    @Override
////    public Page<TypeInfo> getRevisions(
////            RevisionSearchFilter searchFilter,
////            Pageable pageable,
////            ContextInfo contextInfo)
////            throws OperationFailedException,
////            MissingParameterException,
////            PermissionDeniedException,
////            InvalidParameterException {
////        return typeServiceDao.getRevisions(searchFilter, pageable, contextInfo);
////    }
//
//    
//     @Override
//    public Page<TypeInfo> searchTypesByRefObjectUriAndName(
//            List<String> ids,
//            String stateId,
//            String refObjectUri,
//            String name,
//            Pageable pageable, ContextInfo contextInfo)
//            throws OperationFailedException,
//            MissingParameterException,
//            PermissionDeniedException,
//            InvalidParameterException {
//         System.out.println("Reached Service");
//        return typeServiceDao.searchTypesByRefObjectUriAndName(
//                ids,
//                stateId,
//                refObjectUri,
//                name,
//                pageable,
//                contextInfo);
//    }
//
//
//}
