/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.ems.common.dto.iface;

import java.util.Date;

/**
 * This Interface is provides contract for MetaInfo.
 *
 * @author Hiren Morzariya
 * @since 2021-2-11
 */
public interface Meta {

    /**
     * The date and time the thing being described with this meta information
     * created.
     *
     * @return CreatedAt
     * @readOnly
     * @required
     */
    public Date getCreatedAt();

    /**
     * The principal who created the thing being described with this meta
     * information.
     *
     * @return CreateBy
     * @readOnly
     * @required
     */
    public String getCreatedBy();

    /**
     * The date and time the thing being described with this meta information
     * was last updated.
     *
     * @return UpdatedAT
     * @readOnly
     * @required
     */
    public Date getUpdatedAt();

    /**
     * The principal who last updated the thing being described with this meta
     * information.
     *
     * @return UpdatedBy
     * @readOnly
     * @required
     */
    public String getUpdatedBy();

    
}
