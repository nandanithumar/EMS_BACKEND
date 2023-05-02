/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.ems.common.dto.info;

import com.argus.ems.common.dto.iface.TypeStatelessEntity;
import java.io.Serializable;

/**
 * This class is provides implementation for TypeStatelessEntity.
 */
public class TypeStatelessEntityInfo
        extends HasMetaInfo
        implements TypeStatelessEntity, Serializable {

   
    private String name;

  
    private RichTextInfo description;

    /**
     * Constructs a new EntityInfo.
     */
    public TypeStatelessEntityInfo() {
    }

    /**
     * Constructs a new EntityInfo from another Entity.
     *
     * @param typeStatelessEntity the TypeStatelessEntity to copy
     */
    public TypeStatelessEntityInfo(TypeStatelessEntity typeStatelessEntity) {
        super(typeStatelessEntity);
        if (typeStatelessEntity != null) {
            this.name = typeStatelessEntity.getName();
            if (typeStatelessEntity.getDescription() != null) {
                this.description = new RichTextInfo(typeStatelessEntity.getDescription());
            }
        }
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
