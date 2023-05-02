/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.ems.common.dto.info;

import com.argus.ems.common.dto.iface.HasMeta;
import java.io.Serializable;

/**
 * This class is provides implementation for HasMeta.
 *
 * @author Hiren Morzariya
 * @since 2021-2-19
 */
public class HasMetaInfo implements HasMeta, Serializable {

    
    private MetaInfo meta;

    public HasMetaInfo() {
    }

    /**
     * This is copy ConStructure that make deep copy of the hasMeta.
     *
     * @param hasMeta hasMeta
     */
    public HasMetaInfo(HasMeta hasMeta) {
        if (hasMeta != null) {
            this.meta = new MetaInfo(hasMeta.getMeta());
        }
    }

    @Override
    public MetaInfo getMeta() {
        if (this.meta == null) {
            this.meta = new MetaInfo();
        }
        return this.meta;
    }

    public void setMeta(MetaInfo meta) {
        this.meta = meta;
    }

}
