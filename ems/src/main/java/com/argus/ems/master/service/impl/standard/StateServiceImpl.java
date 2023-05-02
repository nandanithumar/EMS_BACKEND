/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.ems.master.service.impl.standard;

import com.argus.ems.common.constant.Constant;
import com.argus.ems.common.dto.info.ContextInfo;
import com.argus.ems.common.dto.info.ValidationResultInfo;
import com.argus.ems.common.exceptioncontroller.exception.DataValidationErrorException;
import com.argus.ems.common.exceptioncontroller.exception.DoesNotExistException;
import com.argus.ems.common.exceptioncontroller.exception.InvalidParameterException;
import com.argus.ems.common.exceptioncontroller.exception.MissingParameterException;
import com.argus.ems.common.exceptioncontroller.exception.OperationFailedException;
import com.argus.ems.common.exceptioncontroller.exception.PermissionDeniedException;
import com.argus.ems.common.exceptioncontroller.exception.VersionMismatchException;
import com.argus.ems.master.dto.info.StateInfo;
import com.argus.ems.master.service.contract.StateService;
import com.argus.ems.master.service.contract.StateServiceBaseImpl;
import com.argus.ems.master.service.impl.dao.StateServiceDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * This StateServiceImpl is for standard implementation for state service.
 *
 */
@Service

public class StateServiceImpl extends StateServiceBaseImpl implements StateService {

    @Autowired
    StateServiceDaoImpl stateServiceDao;

    @PostConstruct
    public void setNextDecorator() {
        super.setNextDecorator(stateServiceDao);
    }

  
    @Override
    public StateInfo createState(StateInfo stateInfo, ContextInfo contextInfo)
            throws OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException,
            DataValidationErrorException {

        if (StringUtils.isEmpty(stateInfo.getId())) {

            String id = Constant.STATE_ID_PRIFIX
                    + stateInfo.getRefObjectUri().toLowerCase()
                    + Constant.DOT
                    + stateInfo.getName().replaceAll("\\s", "").toLowerCase();

            stateInfo.setId(id);
        }
        return stateServiceDao.createState(stateInfo, contextInfo);
    }

    @Override
    public StateInfo updateState(StateInfo stateInfo, ContextInfo contextInfo)
            throws DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException,
            VersionMismatchException,
            DataValidationErrorException {
        return stateServiceDao.updateState(stateInfo, contextInfo);
    }

    @Override
    public StateInfo getStateById(String stateId, ContextInfo contextInfo)
            throws DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException {
        return stateServiceDao.getStateById(stateId, contextInfo);
    }

    @Override
    public StateInfo deleteState(String stateId, ContextInfo contextInfo)
            throws DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException {
        return stateServiceDao.deleteState(stateId, contextInfo);
    }

    @Override
    public Page<StateInfo> getAllStates(StateInfo stateInfo,
            Pageable pageable,
            ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return stateServiceDao.getAllStates(stateInfo, pageable, contextInfo);
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public List<ValidationResultInfo> validateState(String validationTypeKey,
            StateInfo stateInfo, ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return stateServiceDao.validateState(
                validationTypeKey,
                stateInfo,
                contextInfo);
    }

//    @Override
//    @Timed(name = "getRevisions")
//    public Page<StateInfo> getRevisions(
//            RevisionSearchFilter searchFilter,
//            Pageable pageable,
//            ContextInfo contextInfo)
//            throws OperationFailedException,
//            MissingParameterException,
//            PermissionDeniedException,
//            InvalidParameterException {
//        return stateServiceDao.getRevisions(searchFilter, pageable, contextInfo);
//    }
    
    
     @Override
    public Page<StateInfo> searchStatesByRefObjectUriAndName(
            List<String> ids,
            String refObjectUri, String stateName,
            Pageable pageable, ContextInfo contextInfo)
            throws 
            DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException {
        return stateServiceDao.searchStatesByRefObjectUriAndName(
                ids,
                refObjectUri,
                stateName,
                pageable,
                contextInfo);
    }

}
