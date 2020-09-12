package com.example.localsewa.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Category {

    @SerializedName("msg")
    private List<Message> msgList = null;

    public List<Message> getMsgList() {
        return msgList;
    }

    public void setMsgList(List<Message> msgList) {
        this.msgList = msgList;
    }
}
