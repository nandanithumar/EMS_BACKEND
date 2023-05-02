/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.ems.common.dto.info;

import com.argus.ems.common.dto.iface.TemporalTypeStatelessEntity;
import java.util.Date;
import java.io.Serializable;

/**
 * This class is provides implementation for TemporalEntity.
 *
 */
public class TemporalTypeStatelessEntityInfo
        extends IdTypeStatelessEntityInfo
        implements TemporalTypeStatelessEntity, Serializable {

    
    private Date effectiveDate;

   
    private Date expirationDate;

    /**
     * Constructs a new TemporalEntityInfo.
     */
    public TemporalTypeStatelessEntityInfo() {
    }

    /**
     * Constructs a new TemporalEntityInfo from another TemporalEntity.
     *
     * @param temporalTypeStatelessEntity the temporalTypeStatelessEntity top
     * copy
     */
    public TemporalTypeStatelessEntityInfo(
            TemporalTypeStatelessEntity temporalTypeStatelessEntity) {
        super(temporalTypeStatelessEntity);
        if (temporalTypeStatelessEntity != null) {
            Date newEffectiveDate = temporalTypeStatelessEntity.getEffectiveDate();
            Date newExpirationDate = temporalTypeStatelessEntity.getExpirationDate();
            this.effectiveDate = new Date(newEffectiveDate.getTime());
            this.expirationDate = new Date(newExpirationDate.getTime());
        }
    }

    @Override
    public Date getEffectiveDate() {
        return effectiveDate != null
                ? new Date(effectiveDate.getTime()) : null;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate != null
                ? new Date(effectiveDate.getTime()) : null;
    }

    @Override
    public Date getExpirationDate() {
        return expirationDate != null
                ? new Date(expirationDate.getTime()) : null;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate != null
                ? new Date(expirationDate.getTime()) : null;
    }
}
