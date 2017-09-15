package com.cain.af.api.utils;


import com.cain.af.utils.RestUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 */
public class TokenRequestInterceptor implements Interceptor {

    /**
     * ss
     */
    public TokenRequestInterceptor() {

    }

    /**
     *
     * @param chain s
     * @return s
     * @throws IOException s
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        try {
            request = RestUtil.getInstance().addAcceptLanguage(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chain.proceed(request);
    }
}
