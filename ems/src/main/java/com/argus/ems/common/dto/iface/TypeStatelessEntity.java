/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.ems.common.dto.iface;

/**
 * A common interface pattern for service entities.
 *
 */
public interface TypeStatelessEntity extends HasPrimaryKey, HasMeta {

   
    public String getName();

   
    public RichText getDescription();
}
