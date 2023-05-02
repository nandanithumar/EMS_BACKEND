/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.ems.common.dto.info;

import com.argus.ems.common.dto.iface.RichText;
import java.io.Serializable;

/**
 * This info is for RichText DTO that contains description in plainFormate and
 * FormattedFormate.
 *
 */
public class RichTextInfo implements RichText, Serializable {

   
    private String plain;

   
    private String formatted;

    public RichTextInfo() {
    }

    /**
     * This is copy ConStructure that make deep copy of the richText.
     *
     * @param richText richText
     */
    public RichTextInfo(RichText richText) {
        if (richText != null) {
            this.plain = richText.getPlain();
            this.formatted = richText.getFormatted();
        }
    }

    @Override
    public String getPlain() {
        return plain;
    }

    public void setPlain(String plainText) {
        this.plain = plainText;
    }

    @Override
    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formattedText) {
        this.formatted = formattedText;
    }

    @Override
    public String toString() {
        return "RichTextInfo{" + "plain=" + plain + ", formatted=" + formatted + '}';
    }
}
