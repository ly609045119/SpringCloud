package com.example.demo.utils;

import org.apache.commons.lang.StringUtils;

public class PhoneUtils {

    private static final String OVERLAY = "****";
    private static final int START = 3;
    private static final int END = 7;

    /**
     * 手机号格式校验正则
     */
    public static final String PHONE_REGEX = "^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\\d{8}$";

    /**
     * 手机号脱敏筛选正则
     */
    public static final String PHONE_BLUR_REGEX = "(\\d{3})\\d{4}(\\d{4})";

    /**
     * 手机号脱敏替换正则
     */
    public static final String PHONE_BLUR_REPLACE_REGEX = "$1****$2";

    /**
     * 手机号格式校验
     * @param phone
     * @return
     */
    public static final boolean checkPhone(String phone) {
        if (StringUtils.isEmpty(phone)) {
            return false;
        }
        return phone.matches(PHONE_REGEX);
    }

    /**
     * 手机号脱敏处理
     * @param phone
     * @return
     */
    public static final String blurPhone(String phone) {
        boolean checkFlag = checkPhone(phone);
        if (!checkFlag) {
            throw new IllegalArgumentException("手机号格式不正确!");
        }
        return phone.replaceAll(PHONE_BLUR_REGEX, PHONE_BLUR_REPLACE_REGEX);
    }

    /**
     * 身份证打码操作
     * 132****99308084911
     * @param idCard
     * @return
     */
    public static String maskIdCard(String idCard) {
        if (StringUtils.isEmpty(idCard)) {
            return "";
        }
        return StringUtils.overlay(idCard, OVERLAY, START, END);
    }

}
