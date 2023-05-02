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
import com.argus.ems.master.dto.info.TypeInfo;
import com.argus.ems.master.service.contract.TypeService;
import com.argus.ems.master.service.contract.TypeServiceBaseImpl;
import com.argus.ems.master.service.impl.validation.TypeServiceValidationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(Constant.CONTEXT_PATH + "types")
@CacheConfig(cacheNames = {"type"})
public class TypeServiceRestController extends TypeServiceBaseImpl implements TypeService {

    @Autowired
    TypeServiceValidationImpl typeServiceValidation;

    @Autowired
    private CacheManager cacheManager;

    @PostConstruct
    public void setNextDecorator() {
        super.setNextDecorator(typeServiceValidation);
    }

    @Override
    @PostMapping("/{refObjectUri}")
    @CachePut(cacheNames = "type", key = "#typeInfo.id")
    public TypeInfo createType(
            @RequestBody TypeInfo typeInfo,
            @PathVariable("refObjectUri") String refObjectUri,
            @RequestAttribute(name = "contextInfo", required = false) ContextInfo contextInfo)
            throws OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException,
            DataValidationErrorException {
        System.out.println("controller " + typeInfo);
        cacheManager.getCache("state").clear();
        cacheManager.getCache("type").clear();
        return typeServiceValidation.createType(typeInfo, refObjectUri, null);
    }

    @Override
    public Page<TypeInfo> getAllTypes(TypeInfo typeInfo,
            @PageableDefault(size = 1000) Pageable pageable,
            ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return typeServiceValidation.getAllTypes(typeInfo, pageable, contextInfo);
    }

    @Override
    @CachePut(cacheNames = "type", key = "#typeInfo.id")
    @PutMapping("")
    @ResponseBody
    public TypeInfo updateType(@RequestBody TypeInfo typeInfo,
            @RequestAttribute(name = "contextInfo", required = false) ContextInfo contextInfo)
            throws DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException,
            VersionMismatchException,
            DataValidationErrorException {
        cacheManager.getCache("state").clear();
        cacheManager.getCache("type").clear();
        return typeServiceValidation.updateType(typeInfo, contextInfo);
    }

    @Override
    @GetMapping("/{typeId}")
    @Cacheable(cacheNames = "type", key="#typeId")
    @ResponseBody
    public TypeInfo getTypeById(
            @PathVariable("typeId") String typeId,
            @RequestAttribute(name = "contextInfo", required = false) ContextInfo contextInfo)
            throws DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException {

        return typeServiceValidation.getTypeById(typeId, null);
    }

    @Override
    @DeleteMapping("/{typeId}")
    @CacheEvict(cacheNames = "type", key = "#typeId")
    public TypeInfo deleteType(
            @PathVariable("typeId") String typeId,
            @RequestAttribute(name = "contextInfo", required = false) ContextInfo contextInfo)
            throws DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException,
            DataValidationErrorException,
            VersionMismatchException {
        cacheManager.getCache("state").clear();
        cacheManager.getCache("type").clear();
        return typeServiceValidation.deleteType(typeId, contextInfo);
    }

    @Override
    @PostMapping("/validate/{refObjectUri}")
    public List<ValidationResultInfo> validateType(
            @RequestParam(name = "validationTypeKey", required = false) String validationTypeKey,
            @RequestBody(required = true) TypeInfo typeInfo,
            @PathVariable("refObjectUri") String refObjectUri,
            @RequestAttribute("contextInfo") ContextInfo contextInfo)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        return typeServiceValidation.validateType(validationTypeKey, typeInfo, refObjectUri, null);
    }

    @Override
    @Cacheable(cacheNames = "type")
    @GetMapping("")
    public Page<TypeInfo> searchTypesByRefObjectUriAndName(
            @RequestParam(name = "ids", required = false) List<String> ids,
            @RequestParam(name = "stateId", required = false) String stateId,
            @RequestParam(name = "refObjectUri", required = false) String refObjectUri,
            @RequestParam(name = "name", required = false) String typeName,
            @PageableDefault(size = 1000) Pageable pageable,
            ContextInfo contextInfo)
            throws DoesNotExistException,
            OperationFailedException,
            MissingParameterException,
            PermissionDeniedException,
            InvalidParameterException {

        if (ids.isEmpty() && stateId.equals("") && refObjectUri.equals("") && typeName.equals("")) {
            return getAllTypes(new TypeInfo(), pageable, contextInfo);
        }
        System.out.println("not called");
        return typeServiceValidation.searchTypesByRefObjectUriAndName(
                ids,
                stateId,
                refObjectUri,
                typeName,
                pageable,
                contextInfo);

    }
    
    @CacheEvict(value = "type", allEntries = true)
    @RequestMapping("/clearCache")
    public String clearCache() {
        return "cleared cached";
    }
}
