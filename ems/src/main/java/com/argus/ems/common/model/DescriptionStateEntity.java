/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.ems.common.model;


import com.argus.ems.master.model.StateEntity;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * This model used in model those contains meta, plain and formatted
 * description.
 *
 * @author sudip
 * @since 2021-3-23
 */
@MappedSuperclass
public class DescriptionStateEntity extends StateEntity {

    @Column(name = "description_plain")
    private String descriptionPlain;

    @Column(name = "description_formatted")
    private String descriptionFormatted;


//    public String getDescriptionPlain() {
//        return descriptionPlain;
//    }
//
//    public void setDescriptionPlain(String descriptionPlain) {
//        System.out.println("fruiewebfrujdnhsaifksnhafkisnhdsio");
//        this.descriptionPlain = descriptionPlain;
//    }
//
//    public String getDescriptionFormatted() {
//        System.out.println("me hu getter");
//        return descriptionFormatted;
//    }
//
//    public void setDescriptionFormatted(String descriptionFormatted) {
//        this.descriptionFormatted = descriptionFormatted;
//    }


}