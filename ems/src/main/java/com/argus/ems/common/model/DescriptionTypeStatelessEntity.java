/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.ems.common.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;



@MappedSuperclass
public class DescriptionTypeStatelessEntity extends MetaEntity {

    @Column(name = "description_plain")
    private String descriptionPlain;

    @Column(name = "description_formatted")
    private String descriptionFormatted;

    @Column(name = "state_name")
    private String name;

    public String getDescriptionPlain() {
        return descriptionPlain;
    }

    public void setDescriptionPlain(String descriptionPlain) {
        System.out.println("Setting Plain Description");
        System.out.println(descriptionPlain);
        this.descriptionPlain = descriptionPlain;
    }

    public String getDescriptionFormatted() {
        return descriptionFormatted;
    }

    public void setDescriptionFormatted(String descriptionFormatted) {
        this.descriptionFormatted = descriptionFormatted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
