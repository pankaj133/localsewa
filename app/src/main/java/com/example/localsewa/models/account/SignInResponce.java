package com.example.localsewa.models.account;

import com.google.gson.annotations.SerializedName;

public class SignInResponce {

    @SerializedName("code")
    private String code;

    @SerializedName("msg")
    private String msg;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
