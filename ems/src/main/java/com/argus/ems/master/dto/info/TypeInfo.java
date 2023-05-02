/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.ems.master.dto.info;

import com.argus.ems.common.dto.info.TemporalStateEntityInfo;
import com.argus.ems.master.dto.infc.Type;
import java.io.Serializable;


public class TypeInfo
        extends TemporalStateEntityInfo
        implements Type, Serializable {

    private String refObjectUri;


    public TypeInfo() {
    }

    public TypeInfo(Type type) {
        super(type);
        if (type != null) {
            this.refObjectUri = type.getRefObjectUri();
          
        }
    }

    @Override
    public String getRefObjectUri() {
        return refObjectUri;
    }
    
    public void setRefObjUri(String refObjUri) {
        this.refObjectUri = refObjUri;
    }

   

    @Override
    public String toString() {
        return "TypeInfo{"
                + "id=" + this.getId()
                + ", name=" + this.getName()
                + ", refObjectUri=" + refObjectUri
                + ", effectiveDate" + this.getEffectiveDate()
                + ", expirationDate" + this.getExpirationDate()
                + ", stateId=" + this.getStateId()
                + ", meta=" + this.getMeta()
                + ", description=" + this.getDescription()
                + '}';
    }

}
