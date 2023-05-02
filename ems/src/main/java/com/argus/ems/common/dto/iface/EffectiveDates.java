package com.argus.ems.common.dto.iface;

import java.util.Date;

public interface EffectiveDates {

    /**
     * Date/time this object became effective. Must be less than or equal to the
     * expirationDate specified.
     *
     * @return Effective Date
     */
    public Date getEffectiveDate();

    /**
     * Date/time this relationship is no longer effective. Must be greater than
     * or equal to the effectiveDate specified.
     *
     * @return Expiration Date
     */
    public Date getExpirationDate();
}
