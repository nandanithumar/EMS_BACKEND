/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.ems.common.dto.info;

import com.argus.ems.common.dto.iface.TemporalStateEntity;
import java.io.Serializable;
import java.util.Date;

/**
 * This class is provides implementation for TemporalEntity.
 *
 * @author Hiren Morzariya
 * @since 2021/03/23
 */
public class TemporalStateEntityInfo extends IdStateEntityInfo implements TemporalStateEntity, Serializable {

    private Date effectiveDate;

   
    private Date expirationDate;

    /**
     * Constructs a new TemporalEntityInfo.
     */
    public TemporalStateEntityInfo() {
    }

    /**
     * Constructs a new TemporalStateEntityInfo from another
     * TemporalStateEntity.
     *
     * @param temporalStateEntity the temporalStateEntity top copy
     */
    public TemporalStateEntityInfo(
            TemporalStateEntity temporalStateEntity) {
        super(temporalStateEntity);
        if (temporalStateEntity != null) {
            Date newEffectiveDate = temporalStateEntity.getEffectiveDate();
            Date newExpirationDate = temporalStateEntity.getExpirationDate();
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
