package com.example.localsewa.models.account;

import com.google.gson.annotations.SerializedName;

public class SignInVerifyResponce {

        @SerializedName("code")

        private Integer code;
        @SerializedName("msg")

        private SignInMsg signInMsg;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public SignInMsg getMsg() {
            return signInMsg;
        }

        public void setMsg(SignInMsg msg) {
            this.signInMsg = msg;
        }

    }


