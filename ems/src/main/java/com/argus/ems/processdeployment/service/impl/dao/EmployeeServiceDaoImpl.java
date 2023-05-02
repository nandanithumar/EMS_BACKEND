///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.argus.ems.processdeployment.service.impl.dao;
//
//import com.argus.ems.master.service.impl.dao.*;
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
//import com.argus.ems.master.mapper.TypeMapper;
//import com.argus.ems.master.model.TypeEntity;
//import com.argus.ems.master.repository.TypeRepository;
//import com.argus.ems.master.service.contract.TypeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
//import java.util.*;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.CollectionUtils;
//
///**
// * This TypeServiceDaoImpl contains DAO implementation for type service.
// *
// * @author akshar
// * @since 2021-2-17
// */
//@Service
//public class EmployeeServiceDaoImpl implements TypeService {
//
//    @Autowired
//    TypeRepository typeRepository;
//
//    /**
//     * {@inheritdoc}
//     */
//    @Override
//    public TypeInfo createType(
//            TypeInfo typeInfo,
//            String refObjUri,
//            ContextInfo contextInfo)
//            throws OperationFailedException,
//            MissingParameterException,
//            PermissionDeniedException,
//            InvalidParameterException,
//            DataValidationErrorException {
//        System.out.println("rfwehdnddeyufdhWEUOIRH3RHWFUIWHEQFUIDSFHNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");
//        TypeEntity type = TypeMapper.convertTypeInfoToType(typeInfo);
//        if (StringUtils.isEmpty(type.getId())) {
//            type.setId(UUID.randomUUID().toString());
//        }
//        Optional<TypeEntity> tempchecker= typeRepository.findById("1");
//        TypeEntity hello = typeRepository.save(type);
//        return TypeMapper.convertTypeToTypeInfo(type);
//    }
//
//    /**
//     * {@inheritdoc}
//     */
//    @Override
//    @Transactional
//    public TypeInfo updateType(TypeInfo typeInfo, ContextInfo contextInfo)
//            throws DoesNotExistException,
//            OperationFailedException,
//            MissingParameterException,
//            PermissionDeniedException,
//            InvalidParameterException,
//            VersionMismatchException,
//            DataValidationErrorException {
//        Optional<TypeEntity> stateOptional = typeRepository
//                .findById(typeInfo.getId());
//        if (!stateOptional.isPresent()) {
//            throw new DoesNotExistException("State not found");
//        }
//        TypeEntity type = TypeMapper.convertTypeInfoToType(typeInfo);
//        type = typeRepository.save(type);
//        return TypeMapper.convertTypeToTypeInfo(type);
//    }
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
//        if (StringUtils.isEmpty(typeId)) {
//            throw new DoesNotExistException("Type by id :"
//                    + typeId
//                    + " not found");
//        }
//        Optional<TypeEntity> typeOptional = typeRepository.findById(typeId);
//        if (!typeOptional.isPresent()) {
//            throw new DoesNotExistException("Type :"
//                    + typeId
//                    + " not found");
//        }
//        return TypeMapper.convertTypeToTypeInfo(typeOptional.get());
//    }
//
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
//        return new ArrayList<>();
//    }
//
//    @Override
//    public TypeInfo deleteType(String typeId, ContextInfo contextInfo)
//            throws DoesNotExistException,
//            OperationFailedException,
//            MissingParameterException,
//            PermissionDeniedException {
//        if (StringUtils.isEmpty(typeId)) {
//            throw new MissingParameterException("State id is missing or invalid");
//        }
//        Optional<TypeEntity> typeOptional = typeRepository.findById(typeId);
//        if (!typeOptional.isPresent()) {
//            throw new DoesNotExistException("State not found");
//        }
//        TypeEntity type = typeOptional.get();
//        typeRepository.delete(type);
//        return TypeMapper.convertTypeToTypeInfo(type);
//    }
//
//    @Override
//    public Page<TypeInfo> getAllTypes(TypeInfo typeInfo,Pageable pageable, ContextInfo contextInfo) throws DoesNotExistException, OperationFailedException, MissingParameterException, PermissionDeniedException, InvalidParameterException {
//        Page<TypeEntity> types = typeRepository.findAll(pageable);
//        List<TypeInfo> s = new ArrayList<>();
//        for (TypeEntity type : types.getContent()) {
//            s.add(TypeMapper.convertTypeToTypeInfo(type));
//        }
//        return new PageImpl(s, pageable,s.size());
//    }
//    
//     @Override
//    public Page<TypeInfo> searchTypesByRefObjectUriAndName(
//            List<String> ids,
//            String stateId,
//            String refObjectUri,
//            String name,
//            Pageable pageable,
//            ContextInfo contextInfo)
//            throws OperationFailedException,
//            MissingParameterException,
//            PermissionDeniedException,
//            InvalidParameterException {
//
//        if (!CollectionUtils.isEmpty(ids)) {
//            return this.searchTypesById(ids, pageable);
//        } else {
//            Page<Object[]> types;
//            if (StringUtils.isEmpty(name)) {
//                name = "";
//            }
//            System.out.println("name" + name);
//            if (StringUtils.isEmpty(stateId)) {
//                stateId = null;
//            }
//            System.out.println("stateId" + stateId);
//            if (!StringUtils.isEmpty(name) || !StringUtils.isEmpty(stateId)) {
//                types = typeRepository
//                        .findByRefObjectUriAndNameContainingIgnoreCase(
//                                stateId,
//                                refObjectUri,
//                                name,
//                                pageable);
//            } else {
//                System.out.println("Inside Else");
//                types = typeRepository
//                        .findByRefObjectUriContainingIgnoreCase(refObjectUri, pageable);
//                System.out.println("types are " + types);
//            }
//            if (types.isEmpty()) {
//                System.out.println("Tyoes are empty");
//                return new PageImpl<>(new ArrayList<>(),
//                        pageable,
//                        0);
//            }
//            System.out.println("Hello");
//            List<TypeInfo> typeInfos = TypeMapper.convertTypeObjectsToTypeInfos(types.getContent());
//            System.out.println(typeInfos);
//            System.out.println("Reached here");
//            return new PageImpl<>(typeInfos,
//                    pageable,
//                    types.getTotalElements());
//        }
//
//    }
//
//    public Page<TypeInfo> searchTypesById(
//            List<String> ids,
//            Pageable pageable)
//            throws OperationFailedException,
//            MissingParameterException,
//            PermissionDeniedException,
//            InvalidParameterException {
//        List<TypeEntity> types = typeRepository.findTypesByIds(ids);
//        if (CollectionUtils.isEmpty(types)) {
//            return new PageImpl<>(
//                    new ArrayList<>(),
//                    pageable,
//                    0);
//        }
//
//        List<TypeInfo> typeInfos = TypeMapper.convertTypesToTypeInfos(types);
//
//        return new PageImpl<>(typeInfos,
//                pageable,
//                typeInfos.size());
//    }
//
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
////        return auditUtils.<TypeInfo, TypeEntity, String>getRevisionEntitiesPage(
////                TypeEntity.class,
////                searchFilter.getIds(),
////                searchFilter,
////                false,
////                pageable,
////                TypeMapper::convertTypeToTypeInfo
////        );
////    }
//}
