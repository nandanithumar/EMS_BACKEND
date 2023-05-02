/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.ems.common.dto.info;

import com.argus.ems.common.dto.iface.IdTypeStatelessEntity;
import java.io.Serializable;

/**
 * This class is provides implementation for IdTypeStatelessEntity.
 */
public class IdTypeStatelessEntityInfo
        extends TypeStatelessEntityInfo
        implements IdTypeStatelessEntity, Serializable {

   
    private String id;

    /**
     * Constructs a new IdEntityInfo.
     */
    public IdTypeStatelessEntityInfo() {
    }

    /**
     * Constructs a new IdEntityInfo from another IdEntity.
     *
     * @param idEntity the IdEntity to copy
     */
    public IdTypeStatelessEntityInfo(IdTypeStatelessEntity idEntity) {
        super(idEntity);
        if (idEntity != null) {
            this.id = idEntity.getId();
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
