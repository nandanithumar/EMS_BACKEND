package com.argus.ems.master.service.impl.dao;

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
import com.argus.ems.master.mapper.StateMapper;
import com.argus.ems.master.model.StateEntity;
import com.argus.ems.master.repository.StateRepository;
import com.argus.ems.master.service.contract.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import java.util.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.CollectionUtils;

@Service
public class StateServiceDaoImpl implements StateService {

    @Autowired
    StateRepository stateRepository;

    @Override
    @Transactional
    public StateInfo createState(StateInfo stateInfo, ContextInfo contextInfo)
            throws OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException,
            DataValidationErrorException {
        
        System.out.println("***************************************DAOIMPL******************************************");
        StateEntity state = StateMapper.convertStateInfoToState(stateInfo);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++=State :" + state);
        
        StateEntity s1 = stateRepository.save(state);

        System.out.println("_________________________________________________________------Info :" + s1);

        StateInfo info = StateMapper.convertStateToStateInfo(state);

        System.out.println("wefhweuighfdiuhgp4theiuf       " + info);

        return info;
    }

    @Override
    @Transactional
    public StateInfo updateState(StateInfo stateInfo, ContextInfo contextInfo)
            throws DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException,
            VersionMismatchException,
            DataValidationErrorException {
        Optional<StateEntity> stateOptional = stateRepository
                .findById(stateInfo.getId());
        if (!stateOptional.isPresent()) {
            throw new DoesNotExistException("State not found");
        }
        StateEntity state = StateMapper.convertStateInfoToState(stateInfo);
        state = stateRepository.save(state);
        return StateMapper.convertStateToStateInfo(state);
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public StateInfo getStateById(String stateId, ContextInfo contextInfo)
            throws DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException {
        if (StringUtils.isEmpty(stateId)) {
            throw new DoesNotExistException("State by id :"
                    + stateId
                    + " not found");
        }
        Optional<StateEntity> stateOptional = stateRepository.findById(stateId);
        if (!stateOptional.isPresent()) {
            throw new DoesNotExistException("State by id :"
                    + stateId
                    + " not found");
        }
        return StateMapper.convertStateToStateInfo(stateOptional.get());
    }

    @Override
    public StateInfo deleteState(String stateId, ContextInfo contextInfo)
            throws DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException {
        if (StringUtils.isEmpty(stateId)) {
            throw new DoesNotExistException("State id is missing or invalid");
        }
        Optional<StateEntity> stateOptional = stateRepository.findById(stateId);
        if (!stateOptional.isPresent()) {
            throw new DoesNotExistException("State not found");
        }
        StateEntity state = stateOptional.get();
        System.out.println("Deleting state with" + state);
        stateRepository.delete(state);
        return StateMapper.convertStateToStateInfo(state);

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
        return new ArrayList<>();
    }

    @Override
    public Page<StateInfo> getAllStates(StateInfo stateInfo,
            Pageable pageable,
            ContextInfo contextInfo)
            throws DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException {
        Page<StateEntity> states = stateRepository.findAll(pageable);
        List<StateInfo> s = new ArrayList<>();
        for (StateEntity state : states.getContent()) {
            s.add(StateMapper.convertStateToStateInfo(state));
        }
        return new PageImpl(s, pageable, s.size());
    }
    
    @Override
    public Page<StateInfo> searchStatesByRefObjectUriAndName(
            List<String> ids,
            String refObjectUri,
            String stateName,
            Pageable pageable,
            ContextInfo contextInfo)
            throws
              DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException {

        if (!CollectionUtils.isEmpty(ids)) {
            return this.searchStatesById(ids, pageable);
        } else {
            
            Page<StateEntity> states;
            if (!StringUtils.isEmpty(stateName)) {
                System.out.println(refObjectUri);
                System.out.println(stateName);
                states = stateRepository
                        .findByNameContainingIgnoreCase(stateName, pageable);
                System.out.println(states);
            } else {
                 System.out.println(refObjectUri);
                states = stateRepository
                        .findByRefObjectUriContainingIgnoreCase(refObjectUri, pageable);
               
            }
            if (states.isEmpty()) {
                return new PageImpl<>(new ArrayList<>(),
                        pageable,
                        0);
            }
            List<StateInfo> stateInfos = StateMapper
                    .convertStatesToStateInfos(states.getContent());
            return new PageImpl<>(stateInfos,
                    pageable,
                    states.getTotalElements());
        }

    }


    public Page<StateInfo> searchStatesById(
            List<String> ids,
            Pageable pageable)
            throws OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException {

        List<StateEntity> states
                = stateRepository.findStatesByIds(ids);
        if (CollectionUtils.isEmpty(states)) {
            return new PageImpl<>(
                    new ArrayList<>(),
                    pageable,
                    0);
        }

        List<StateInfo> stateInfos = StateMapper
                .convertStatesToStateInfos(states);

        return new PageImpl<>(stateInfos,
                pageable,
                stateInfos.size());
    }
    
//    @Override
//    public Page<StateInfo> getRevisions(
//            RevisionSearchFilter searchFilter,
//            Pageable pageable,
//            ContextInfo contextInfo)
//            throws OperationFailedException,
//            MissingParameterException,
//            PermissionDeniedException,
//            InvalidParameterException {
//        return auditUtils.<StateInfo, StateEntity, String>getRevisionEntitiesPage(
//                StateEntity.class,
//                searchFilter.getIds(),
//                searchFilter,
//                false,
//                pageable,
//                StateMapper::convertStateToStateInfo
//        );
//    }
}
