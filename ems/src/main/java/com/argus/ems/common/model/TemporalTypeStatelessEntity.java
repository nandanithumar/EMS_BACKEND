package com.argus.ems.common.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@MappedSuperclass
public class TemporalTypeStatelessEntity extends IdTypeStatelessEntity {

    @Column(name = "effective_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date effectiveDate;

    @Column(name = "expiration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;

    public Date getEffectiveDate() {
//        System.out.println(effectiveDate);
        return effectiveDate != null
                ? new Date(effectiveDate.getTime()) : null;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate != null
                ? new Date(effectiveDate.getTime()) : null;
    }

    public Date getExpirationDate() {
        return expirationDate != null
                ? new Date(expirationDate.getTime()) : null;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate != null
                ? new Date(expirationDate.getTime()) : null;
    }
}
