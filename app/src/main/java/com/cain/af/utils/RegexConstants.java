package com.cain.af.utils;

/**
 * Created by XIAOHONG
 * Author: XIAOHONG.
 * Date: 2017/7/31.
 */

public class RegexConstants {
    /**
     * 正则：手机号（简单）
     */
    public static final String REGEX_MOBILE_SIMPLE = "^[1][3-8][0-9]{9}$";
    /**
     * 正则： 邮箱
     */
    public static final String REGEX_EMAIL = "^(?![\\s\\S]*[^\\x00-\\xff]+[\\s\\S]*$)(?=\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$).{5,100}$";


    /**
     * 正则： 数字 字母 特殊字符 8 - 20 位
     */
    public static final String REGEX_NUM_LATTER_CHAR = "(?!^(\\d+|[a-zA-Z]+|[~!@#$%^&*(\\)\\-_+=]+)$)^[\\w~!@#$%\\\\^&*(\\)\\-_+=]{7,20}$";


}
