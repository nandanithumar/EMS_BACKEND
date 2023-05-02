/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.ems.common.dto.info;

import com.argus.ems.common.constant.ErrorLevel;
import com.argus.ems.common.dto.iface.ValidationResult;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Information about the results of a data validation.
 *
 */
public class ValidationResultInfo implements ValidationResult, Serializable {

    private static final long serialVersionUID = 1L;

    
    private String element;

   
    private ErrorLevel level;

   
    private String message;

    private String stackTrace;

    
    private Map<String, String> references;

    public ValidationResultInfo() {
        this.level = ErrorLevel.OK;
    }

    public ValidationResultInfo(String element) {
        this();
        this.element = element;
    }

    public ValidationResultInfo(String element, ErrorLevel level, String message) {
        this.element = element;
        this.level = level;
        this.message = message;
    }

    /**
     * This is copy ConStructure that make deep copy of the validationResult.
     *
     * @param validationResult validation Result
     */
    public ValidationResultInfo(ValidationResult validationResult) {
        if (validationResult != null) {
            this.element = validationResult.getElement();
            this.level = validationResult.getLevel();
            this.message = validationResult.getMessage();
            this.references = new HashMap<>(validationResult.getReferences());
            this.stackTrace = validationResult.getStackTrace();
        }
    }

    @Override
    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    @Override
    public ErrorLevel getLevel() {
        return this.level;
    }

    public void setLevel(ErrorLevel level) {
        this.level = level;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ValidationResultInfo{" + "element=" + element + ", level=" + level + ", message=" + message + ",references=" + references + '}';
    }

    /**
     * Convenience method to check if this is Ok
     */
    public boolean isOk() {
        return this.level == ErrorLevel.OK;
    }

    /**
     * Convenience method to check if this is Warn
     */
    public boolean isWarn() {
        return this.level == ErrorLevel.WARN;
    }

    /**
     * Convenience method to check if this is Error
     */
    public boolean isError() {
        return this.level == ErrorLevel.ERROR;
    }

    /**
     * Convenience method. Adds a message with an error level of WARN
     *
     * @param message the warning message
     */
    public void setWarning(String message) {
        this.level = ErrorLevel.WARN;
        this.message = message;
    }

    /**
     * Convenience method. Adds a message with an error level of ERROR
     *
     * @param message the error message to add
     */
    public void setError(String message) {
        this.level = ErrorLevel.ERROR;
        this.message = message;
    }

    public static boolean hasValidationErrors(
            List<ValidationResultInfo> validationResults,
            ErrorLevel threshold, List<String> ignoreFields) {
        if (validationResults == null) {
            return false;
        }
        return validationResults.stream().anyMatch(validationResult
                -> //Ignore any fields that are in the list
                ((ignoreFields == null
                || (ignoreFields != null
                && !ignoreFields.contains(validationResult.getElement())))
                && isSurpassingThreshold(validationResult.getLevel(),
                        threshold))
        );
    }

    private static boolean isSurpassingThreshold(ErrorLevel currentLevel,
            ErrorLevel threshold) {
        return currentLevel.compareTo(threshold) >= 0;
    }

    @Override
    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    @Override
    public Map<String, String> getReferences() {
        if (this.references == null) {
            this.references = new HashMap<>();
        }
        return references;
    }

    public void setReferences(Map<String, String> references) {
        this.references = references;
    }

}
