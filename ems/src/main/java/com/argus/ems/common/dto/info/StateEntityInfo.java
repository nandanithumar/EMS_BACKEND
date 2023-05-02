/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.ems.common.dto.info;

import com.argus.ems.common.dto.iface.StateEntity;
import java.io.Serializable;

/**
 * This class is provides implementation for StateEntityInfo.
 *
 * @author Hiren Morzariya
 * @since 2021/03/23
 */
public class StateEntityInfo extends HasMetaInfo implements StateEntity, Serializable {

    
    private String stateId;

    
    private String name;

    
    private RichTextInfo description;

    /**
     * Constructs a new StateEntityInfo.
     */
    public StateEntityInfo() {
    }

    /**
     * Constructs a new StateEntityInfo from another StateEntity.
     *
     * @param stateEntity the StateEntity to copy
     */
    public StateEntityInfo(StateEntity stateEntity) {
        super(stateEntity);
        if (null != stateEntity) {
            this.stateId = stateEntity.getStateId();
            this.name = stateEntity.getName();
            if (stateEntity.getDescription() != null) {
                this.description = new RichTextInfo(stateEntity.getDescription());
            }
        }
    }

    @Override
    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public RichTextInfo getDescription() {
        if (this.description == null) {
            this.description = new RichTextInfo();
        }
        return description;
    }

    public void setDescription(RichTextInfo description) {
        this.description = description;
    }
}
