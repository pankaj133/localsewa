
package com.example.localsewa.models.bestsellermodels;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BestSeller {

    private Integer code;
    @SerializedName("msg")

    private List<Msg> msg = null;

    public List<Msg> getMsg() {
        return msg;
    }

    public void setMsg(List<Msg> msg) {
        this.msg = msg;
    }

}
