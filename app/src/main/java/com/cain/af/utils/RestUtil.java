package com.cain.af.utils;

import android.text.TextUtils;


import com.cain.af.config.SPConstants;

import okhttp3.Request;

/**
 * Created by cain on 2017/8/18.
 */

public class RestUtil {

    private static RestUtil instance;
    private static Object lock = new Object();


    private RestUtil() {

    }

    public static RestUtil getInstance() throws Exception {
        if (null == instance) {

            synchronized (lock) {
                if (null == instance) {
                    instance = new RestUtil();
                }
            }
        }
        return instance;

    }

    public Request addAcceptLanguage(Request request) {
        String language = SPUtils.getString(SPConstants.ACCEPT_LANGUAGE,"zh-CN");
        if (TextUtils.isEmpty(language)) {
            return request;
        }
        return request.newBuilder().addHeader("Accept-Language", language).build();
    }


}
