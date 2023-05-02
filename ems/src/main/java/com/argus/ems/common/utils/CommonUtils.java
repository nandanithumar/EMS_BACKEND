package com.argus.ems.common.utils;


import org.apache.commons.lang3.StringUtils;

public final class CommonUtils {

    private CommonUtils() {
    }

    public static String formatTRN(Integer trn) {
        if(trn == null) return "";
        return StringUtils.leftPad(trn.toString(), 9, "0");
    }

    public static String formatTRN(String trn) {
        if(trn == null) return "";
        return StringUtils.leftPad(trn, 9, "0");
    }
}
