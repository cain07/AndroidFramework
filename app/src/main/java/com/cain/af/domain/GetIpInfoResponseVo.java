package com.cain.af.domain;

/**
 * Created by cain on 16/5/18.
 */
public class GetIpInfoResponseVo {

    private int code;

    private GetIpInfoResponse data;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public void setData(GetIpInfoResponse data) {
        this.data = data;
    }

    public GetIpInfoResponse getData() {
        return this.data;
    }


    @Override
    public String toString() {
        return "GetIpInfoResponseVo{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }
}
