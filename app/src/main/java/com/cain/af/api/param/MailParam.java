package com.cain.af.api.param;

/**
 * Created by mac on 17/7/18.
 */
public class MailParam {

    private String type;

    private String postid;

    public MailParam(String type, String postid) {
        this.type = type;
        this.postid = postid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }
}
