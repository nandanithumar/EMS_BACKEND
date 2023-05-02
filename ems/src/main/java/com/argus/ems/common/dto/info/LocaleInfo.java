/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.ems.common.dto.info;

import com.argus.ems.common.dto.iface.Locale;
import java.io.Serializable;

/**
 * This info is for locale DTO that contains request locale regions, script,
 * variant and language.
 *
 */
public class LocaleInfo implements Locale, Serializable {

    
    private String localeLanguage;
    
    
    private String localeVariant;
    
    
    private String localeRegion;
    
    
    private String localeScript;

    public LocaleInfo() {
    }

    /**
     * This is copy ConStructure that make deep copy of the locale.
     *
     * @param locale locale
     */
    public LocaleInfo(Locale locale) {
        if (locale != null) {
            this.localeLanguage = locale.getLocaleLanguage();
            this.localeRegion = locale.getLocaleRegion();
            this.localeScript = locale.getLocaleScript();
            this.localeVariant = locale.getLocaleVariant();
        }
    }

    @Override
    public String getLocaleLanguage() {
        return localeLanguage;
    }

    public void setLocaleLanguage(String localeLanguage) {
        this.localeLanguage = localeLanguage;
    }

    @Override
    public String getLocaleVariant() {
        return localeVariant;
    }

    public void setLocaleVariant(String localeVariant) {
        this.localeVariant = localeVariant;
    }

    @Override
    public String getLocaleRegion() {
        return localeRegion;
    }

    public void setLocaleRegion(String localeRegion) {
        this.localeRegion = localeRegion;
    }

    @Override
    public String getLocaleScript() {
        return localeScript;
    }

    public void setLocaleScript(String localeScript) {
        this.localeScript = localeScript;
    }

    @Override
    public String toString() {
        return "LocaleInfo{" + "localeLanguage=" + localeLanguage + ", localeVariant=" + localeVariant + ", localeRegion=" + localeRegion + ", localeScript=" + localeScript + '}';
    }
}
