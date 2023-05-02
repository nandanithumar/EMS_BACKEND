/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.ems.common.dto.info;

import com.argus.ems.common.dto.iface.Meta;
import java.io.Serializable;
import java.util.Date;

/**
 * This info is for meta DTO that contains
 * createdAt,createdBy,updatedAt,updatedBy and version.
 *
 */
public class MetaInfo implements Meta, Serializable {

  
    private Date createdAt;

   
    private String createdBy;

   
    private Date updatedAt;

    
    private String updatedBy;

   

    public MetaInfo() {
    }

    /**
     * This is copy ConStructure that make deep copy of the meta.
     *
     * @param meta meta
     */
    public MetaInfo(Meta meta) {
        if (meta != null) {
            if (meta.getCreatedAt() != null) {
                this.createdAt = new Date(meta.getCreatedAt().getTime());
            }
            if (meta.getUpdatedAt() != null) {
                this.updatedAt = new Date(meta.getUpdatedAt().getTime());
            }
            this.createdBy = meta.getCreatedBy();
            this.updatedBy = meta.getUpdatedBy();
        }
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt != null
                ? new Date(createdAt.getTime()) : null;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt != null
                ? new Date(updatedAt.getTime()) : null;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

  
    @Override
    public Date getCreatedAt() {
        return createdAt != null
                ? new Date(createdAt.getTime()) : null;
    }

    @Override
    public String getCreatedBy() {
        return this.createdBy;
    }

    @Override
    public Date getUpdatedAt() {
        return updatedAt != null
                ? new Date(updatedAt.getTime()) : null;
    }

    @Override
    public String getUpdatedBy() {
        return this.updatedBy;
    }

    @Override
    public String toString() {
        return "MetaInfo{"
                + "createdAt=" + createdAt
                + ", createdBy=" + createdBy
                + ", updatedAt=" + updatedAt
                + ", updatedBy=" + updatedBy
                + '}';
    }
}
