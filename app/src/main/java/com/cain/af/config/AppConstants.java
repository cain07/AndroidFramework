package com.cain.af.config;

/**
 * Created by mac on 17/8/2.
 */

/**
 *
 */
public interface AppConstants {

    /**
     *
     */
    int OUT_PUT_VALUE_TYPE = 2;
    /**
     *
     */
    int MIN_LENGTH = 8;
    /**
     *
     */
    int MAX_LENGTH = 20;
    /**
     *
     */
    int CIPHERTYPE = 1;

    /**
     * 轮询中使用的状态码
     */
    int MSG_ERROR = 0;  //请求失败
    int MSG_OK = 1;  //请求成功
    int MSG_START = 2;  //开起请求
    int MSG_NO_NETWORK = 3; //无网络
    int MSG_CHECK_NETWORK = 4;  //2秒检查网络

    /**
     * 输入数据为空
     */
    int ERROR_INPUT_VALUE_NULL = 0xE0010003;
    /**
     * 输入数据不匹配正则表达式
     */
    int ERROR_INPUT_VALUE_NOT_MATCH_REG = 0xE0010005;
    /**
     *输入长度小于最小长度
     */
    int ERROR_INPUT_LENGTH_IS_SHORTER_THAN_MINLENGTH = 0xB0010007;
    /**
     * 输入长度不在有效范围
     */
    int ERROR_INPUT_FIELD_LENGTH_OUT_RANGE = 0xC0010001;
    /**
     * 英文
     */
    String LANGUAGE_EN_US ="en-US";
    /**
     * 中文
     */
    String LANGUAGE_ZH_CN ="zh-CN";



}
