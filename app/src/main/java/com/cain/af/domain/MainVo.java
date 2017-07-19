package com.cain.af.domain;

import java.util.List;

/**
 * Created by mac on 17/7/18.
 */
public class MainVo {

    private String message;

    private String nu;

    private String ischeck;

    private String condition;

    private String com;

    private String status;

    private String state;

    private List<MailInfo> data ;

    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
    public void setNu(String nu){
        this.nu = nu;
    }
    public String getNu(){
        return this.nu;
    }
    public void setIscheck(String ischeck){
        this.ischeck = ischeck;
    }
    public String getIscheck(){
        return this.ischeck;
    }
    public void setCondition(String condition){
        this.condition = condition;
    }
    public String getCondition(){
        return this.condition;
    }
    public void setCom(String com){
        this.com = com;
    }
    public String getCom(){
        return this.com;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setState(String state){
        this.state = state;
    }
    public String getState(){
        return this.state;
    }
    public void setData(List<MailInfo> data){
        this.data = data;
    }
    public List<MailInfo> getData(){
        return this.data;
    }

    @Override
    public String toString() {
        return "MainVo{" +
                "message='" + message + '\'' +
                ", nu='" + nu + '\'' +
                ", ischeck='" + ischeck + '\'' +
                ", condition='" + condition + '\'' +
                ", com='" + com + '\'' +
                ", status='" + status + '\'' +
                ", state='" + state + '\'' +
                ", data=" + data +
                '}';
    }
}
