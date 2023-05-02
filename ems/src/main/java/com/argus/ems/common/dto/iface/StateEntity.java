/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.ems.common.dto.iface;

/**
 * A common interface pattern for service entities.
 *
 * @author Hiren Morzariya
 * @since 2021/03/23
 */
public interface StateEntity extends HasPrimaryKey, HasState, HasMeta {

   
    public String getName();

   
    public RichText getDescription();
}
