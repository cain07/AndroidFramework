package com.cain.af.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by XIAOFENG
 * Author: XIAOFENG.
 * Date: 2017/7/28.
 */
public class Validator {
    /**
     * 验证邮箱输入是否合法
     *
     * @param strEmail s
     * @return s
     */
    public static boolean isEmail(String strEmail) {
        Pattern pattern = Pattern.compile(RegexConstants.REGEX_EMAIL);
        Matcher matcher = pattern.matcher(strEmail);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    /**
     * 验证是否是手机号码
     *
     * @param str s
     * @return s
     */
    public static boolean isMobile(String str) {
        Pattern pattern = Pattern.compile(RegexConstants.REGEX_MOBILE_SIMPLE);
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    public static boolean isBoo(String strEmail) {
        Pattern pattern = Pattern.compile(RegexConstants.REGEX_NUM_LATTER_CHAR);
        Matcher matcher = pattern.matcher(strEmail);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
