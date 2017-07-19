package com.cain.af.api.utils;

import android.util.Log;

import com.cain.af.BuildConfig;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 生成相应的api service对象
 * Created by mac on 17/7/19.
 */
public class ServiceGenerator {

    private static final String API_BASE_URI = "http://www.kuaidi100.com/";

    private static final String TAG = "ServiceGenerator";

    private static final Object INSTANCE_LOCK = new Object();

    private Retrofit.Builder mRetrofitBuilder;

    private OkHttpClient sOkHttpClient;

    private static ServiceGenerator sServiceGenerator;


    public static ServiceGenerator getServiceGenerator() {
        if (sServiceGenerator == null) {
            synchronized (INSTANCE_LOCK) {
                if (sServiceGenerator == null) {
                    sServiceGenerator = new ServiceGenerator();
                }
            }
        }
        return sServiceGenerator;
    }


    private ServiceGenerator() {

        sOkHttpClient = createOkHttpClient();
        mRetrofitBuilder = new Retrofit.Builder()
                //.baseUrl(BuildConfig.API_BASE_URI)
                .baseUrl(API_BASE_URI)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
    }

    private OkHttpClient createOkHttpClient() {

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        //设置五秒超时
        httpClientBuilder.connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS);


      /*  httpClientBuilder.addInterceptor(new TokenRequestInterceptor())
                .addInterceptor(new EncryptInterceptor())
                .addInterceptor(new GzipInterceptor())
                .addNetworkInterceptor(new StethoInterceptor());


        //在这里可以设置在httpClient的拦截
        if (true || BuildConfig.DEBUG) {
            httpClientBuilder.addInterceptor(new LoggingInterceptor());
        }

        if ("product".equals(BuildConfig.FLAVOR)) {
            httpClientBuilder.addInterceptor(new StatisticsInterceptor());
        }

        try {

            SSLContext sslContext = SSLContext.getInstance("TLS");
            X509TrustManager trustManager = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

            };

            sslContext.init(null, new TrustManager[]{trustManager}, new SecureRandom());
            httpClientBuilder.sslSocketFactory(sslContext.getSocketFactory());

        } catch (NoSuchAlgorithmException e) {
            Log.i(TAG, e.getMessage());
        } catch (KeyManagementException e) {
            Log.i(TAG, e.getMessage());
        }

        httpClientBuilder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });*/

        OkHttpClient client = httpClientBuilder.build();

        return client;
    }

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, true);
    }


    public static <S> S createService(Class<S> serviceClass, boolean resetUrl) {


        Retrofit retrofit;

        retrofit = getServiceGenerator().getRetrofit(resetUrl);

        return retrofit.create(serviceClass);
    }


    public static <S> S createService(Class<S> serviceClass, String url) {

        Retrofit retrofit;

        retrofit = getServiceGenerator().getRetrofit(url);

        return retrofit.create(serviceClass);

    }

    private Retrofit getRetrofit(String url) {
        return mRetrofitBuilder.baseUrl(url + "/api/").client(sOkHttpClient).build();
    }


    private Retrofit getRetrofit(boolean resetUrl) {
        Retrofit retrofit;
//        Log.e(TAG, "getRetrofit---> getServerUrl()" + getServerUrl() + " | resetUrl-->" + resetUrl);
        if (resetUrl) {
            //LogUtils.e("getServerUrl " + getServerUrl());
            retrofit = mRetrofitBuilder.baseUrl(getServerUrl() + "/api/").client(sOkHttpClient).build();
        } else {
            retrofit = mRetrofitBuilder.client(sOkHttpClient).build();
        }
        return retrofit;
    }

    private String getServerUrl() {
       // Log.e("getServerUrl", "getServerUrl->" + RFSPUtil.getServerUrl());
        //return RFSPUtil.getServerUrl();
        return  null;
    }



}
