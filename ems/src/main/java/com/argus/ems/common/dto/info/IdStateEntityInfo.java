/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.ems.common.dto.info;

import com.argus.ems.common.dto.iface.IdStateEntity;
import java.io.Serializable;

/**
 * This class is provides implementation for IdStateEntityInfo.
 *
 * @author Hiren Morzariya
 * @since 2021/03/23
 */
public class IdStateEntityInfo
        extends StateEntityInfo
        implements IdStateEntity, Serializable {

    
    private String id;

    /**
     * Constructs a new IdEntityInfo.
     */
    public IdStateEntityInfo() {
    }

    /**
     * Constructs a new IdStateEntityInfo from another IdStateEntity.
     *
     * @param idStateEntity the IdStateEntity to copy
     */
    public IdStateEntityInfo(IdStateEntity idStateEntity) {
        super(idStateEntity);
        if (idStateEntity != null) {
            this.id = idStateEntity.getId();
        }
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
