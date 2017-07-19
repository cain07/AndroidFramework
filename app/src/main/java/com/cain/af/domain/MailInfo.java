package com.cain.af.domain;

/**
 * Created by mac on 17/7/18.
 */
public class MailInfo {

    private String time;

    private String ftime;

    private String context;

    private String location;

    public void setTime(String time){
        this.time = time;
    }
    public String getTime(){
        return this.time;
    }
    public void setFtime(String ftime){
        this.ftime = ftime;
    }
    public String getFtime(){
        return this.ftime;
    }
    public void setContext(String context){
        this.context = context;
    }
    public String getContext(){
        return this.context;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return this.location;
    }

}
