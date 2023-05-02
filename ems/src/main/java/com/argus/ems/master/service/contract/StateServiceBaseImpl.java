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
import com.argus.ems.master.dto.info.StateInfo;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public class StateServiceBaseImpl implements StateService {
/*Comment for testing*/
    StateService stateService;

    public void setNextDecorator(StateService stateService) {
        this.stateService = stateService;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public StateInfo createState(StateInfo stateInfo, ContextInfo contextInfo) throws OperationFailedException, InvalidParameterException, MissingParameterException, PermissionDeniedException, DataValidationErrorException {
        return stateService.createState(stateInfo, contextInfo);
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public StateInfo updateState(StateInfo stateInfo, ContextInfo contextInfo) throws DoesNotExistException, OperationFailedException, MissingParameterException, PermissionDeniedException, VersionMismatchException, DataValidationErrorException, InvalidParameterException {
        return stateService.updateState(stateInfo, contextInfo);
    }

    @Override
    public Page<StateInfo> searchStatesByRefObjectUriAndName(List<String> ids, String refObjectUri, String name, Pageable pageable, ContextInfo contextInfo) throws DoesNotExistException, OperationFailedException, MissingParameterException, PermissionDeniedException, InvalidParameterException {
        return stateService.searchStatesByRefObjectUriAndName(ids, refObjectUri, name, pageable, contextInfo);
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public List<ValidationResultInfo> validateState(String validationTypeKey, StateInfo stateInfo, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return stateService.validateState(validationTypeKey, stateInfo, contextInfo);
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public StateInfo getStateById(String stateId, ContextInfo contextInfo) throws DoesNotExistException, OperationFailedException, MissingParameterException, PermissionDeniedException, InvalidParameterException {
        return stateService.getStateById(stateId, contextInfo);
    }

    @Override
    public StateInfo deleteState(String stateId, ContextInfo contextInfo) throws DoesNotExistException, OperationFailedException, MissingParameterException, PermissionDeniedException, InvalidParameterException {
        return stateService.deleteState(stateId, contextInfo);
    }

    @Override
    public Page<StateInfo> getAllStates(StateInfo stateInfo, Pageable pageable, ContextInfo contextInfo) throws DoesNotExistException, OperationFailedException, MissingParameterException, PermissionDeniedException, InvalidParameterException {
        return stateService.getAllStates(stateInfo,pageable, contextInfo);
    }

//    @Override
//    public Page<StateInfo> getRevisions(RevisionSearchFilter searchFilter, Pageable pageable, ContextInfo contextInfo) throws OperationFailedException, MissingParameterException, PermissionDeniedException, InvalidParameterException {
//        return stateService.getRevisions(searchFilter, pageable, contextInfo);
//    }

}
