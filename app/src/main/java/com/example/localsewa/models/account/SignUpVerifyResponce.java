package com.example.localsewa.models.account;

import com.google.gson.annotations.SerializedName;

public class SignUpVerifyResponce {



    @SerializedName("code")
    private Integer code;

    @SerializedName("msg")
    private SignUpMsg signUpMsg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public SignUpMsg getSignUpMsg() {
        return signUpMsg;
    }

    public void setSignUpMsg(SignUpMsg signUpMsg) {
        this.signUpMsg = signUpMsg;
    }
}
