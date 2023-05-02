package com.argus.ems.master.service.impl.rest;

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
import com.argus.ems.master.service.impl.validation.StateServiceValidationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

@RestController
@RequestMapping(Constant.CONTEXT_PATH + "states")
@CrossOrigin(origins = "http://localhost:4200")
@CacheConfig(cacheNames = {"state"})
public class StateServiceRestController extends StateServiceBaseImpl implements StateService {

    @Autowired
    StateServiceValidationImpl stateServiceValidation;

    @Autowired
    private CacheManager cacheManager;

    @PostConstruct
    public void setNextDecorator() {
        super.setNextDecorator(stateServiceValidation);
    }

    /**
     * {@inheritdoc}
     */
    @Override
    @CachePut(cacheNames = "state", key = "#stateInfo.id")
    @PostMapping("")
    @ResponseBody
    public StateInfo createState(@RequestBody StateInfo stateInfo,
            @RequestAttribute(name = "contextInfo", required = false) ContextInfo contextInfo)
            throws OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException,
            DataValidationErrorException {
        System.out.println(stateInfo);
        cacheManager.getCache("state").clear();
        cacheManager.getCache("type").clear();
        return stateServiceValidation.createState(stateInfo, null);

    }

//    @GetMapping("/revision")
//    public Page<StateInfo> getRevisions(
//            RevisionSearchFilter searchFilter,
//            @PageableDefault(size = 10, direction = Sort.Direction.DESC) Pageable pageable,
//            @RequestAttribute("contextInfo") ContextInfo contextInfo)
//            throws OperationFailedException,
//            MissingParameterException,
//            PermissionDeniedException,
//            InvalidParameterException {
//        return stateServiceValidation.getRevisions(searchFilter, pageable, contextInfo);
//    }
    /**
     * {@inheritdoc}
     */
    @Override
    @CachePut(cacheNames = "state", key = "#stateInfo.id")
    @PutMapping("")
    @ResponseBody
    public StateInfo updateState(@RequestBody StateInfo stateInfo,
            @RequestAttribute(name = "contextInfo", required = false) ContextInfo contextInfo)
            throws DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException,
            VersionMismatchException,
            DataValidationErrorException {
        StateInfo stateInfo1 = stateServiceValidation.updateState(stateInfo, contextInfo);
        cacheManager.getCache("state").clear();
        cacheManager.getCache("type").clear();
//        Cache cache = cacheManager.getCache("state");
//        cache.put(stateInfo.getId(), stateInfo1);
        return stateInfo1;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    @Cacheable(cacheNames = "state", key = "#stateId")
    @GetMapping("/{stateId}")
    @ResponseBody
    public StateInfo getStateById(
            @PathVariable("stateId") String stateId,
            @RequestAttribute(name = "contextInfo", required = false) ContextInfo contextInfo)
            throws DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException {
        System.out.println("Get State by id called");
        StateInfo s = stateServiceValidation.getStateById(stateId, contextInfo);
        System.out.println(s);
        return s;
    }

    @Override
    @CacheEvict(cacheNames = "state", key = "#stateId")
    @DeleteMapping("/{stateId}")
    public StateInfo deleteState(
            @PathVariable("stateId") String stateId,
            @RequestAttribute(name = "contextInfo", required = false) ContextInfo contextInfo)
            throws DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException {
        System.out.println("Deleting");
        cacheManager.getCache("state").clear();
        cacheManager.getCache("type").clear();
        return stateServiceValidation.deleteState(stateId, contextInfo);
    }

    /**
     * {@inheritdoc}
     *
     * @param stateInfo
     * @param pageable
     * @return
     */
    @Override
    public Page<StateInfo> getAllStates(StateInfo stateInfo,
            @PageableDefault(size = 1000) Pageable pageable,
            ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        System.out.println("state" + stateInfo);
        return stateServiceValidation.getAllStates(stateInfo, pageable, contextInfo);
    }

    @Override
    @PostMapping("/validate")
    public List<ValidationResultInfo> validateState(
            @RequestParam(name = "validationTypeKey", required = true) String validationTypeKey,
            @RequestBody(required = true) StateInfo stateInfo,
            @RequestAttribute("contextInfo") ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return stateServiceValidation.validateState(
                validationTypeKey,
                stateInfo,
                contextInfo);
    }

    @Override
    @Cacheable(cacheNames = "state")
    @GetMapping("")
    public Page<StateInfo> searchStatesByRefObjectUriAndName(
            @RequestParam(name = "ids", required = false) List<String> ids,
            @RequestParam(name = "refObjectUri", required = false) String refObjectUri,
            @RequestParam(name = "name", required = false) String stateName,
            @PageableDefault(size = 1000) Pageable pageable,
            ContextInfo contextInfo)
            throws
            DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException {

        System.out.println(pageable + "+++++++++++++++++++++++++++++++++++++++++++++++++");
        if (ids.isEmpty() && refObjectUri.equals("") && stateName.equals("")) {
            return getAllStates(new StateInfo(), pageable, contextInfo);
        }

        return stateServiceValidation.searchStatesByRefObjectUriAndName(
                ids,
                refObjectUri,
                stateName,
                pageable,
                contextInfo);
    }

    @CacheEvict(value = "states", allEntries = true)
    @RequestMapping("/clearCache1")
    public String clearCache() {
        return "cleared cached";
    }

}
