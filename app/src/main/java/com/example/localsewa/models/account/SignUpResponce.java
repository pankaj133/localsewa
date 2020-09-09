package com.example.localsewa.models.account;

import com.google.gson.annotations.SerializedName;

public class SignUpResponce {


    @SerializedName("code")
    private int code;

    @SerializedName("msg")
    private String scussesmsg;

    @SerializedName("message")
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getScussesmsg() {
        return scussesmsg;
    }

    public void setScussesmsg(String scussesmsg) {
        this.scussesmsg = scussesmsg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
