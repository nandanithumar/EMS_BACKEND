package com.argus.ems.common.utils;

import com.argus.ems.common.exceptioncontroller.exception.OperationFailedException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class JSONUtils {

    private JSONUtils() {
    }

    public static HashMap<String, String> convertStringToHashMap(String jsonString) throws OperationFailedException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<HashMap<String, String>> typeRef = new TypeReference<HashMap<String, String>>() {
        };
        try {
            return mapper.readValue(jsonString, typeRef);
        } catch (IOException e) {
            throw new OperationFailedException("Error while convertStringToHashMap", e);
        }
    }

    public static String convertHashMapToString(Map<String, String> hashMap) throws OperationFailedException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(hashMap);
        } catch (IOException e) {
            throw new OperationFailedException("Error while convertHashMapToString", e);
        }
    }
}
