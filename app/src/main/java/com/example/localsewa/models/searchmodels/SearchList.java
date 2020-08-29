
package com.example.localsewa.models.searchmodels;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchList {


    @SerializedName("msg")
    private List<SearchMsg> msg = null;

    public List<SearchMsg> getMsg() {
        return msg;
    }

    public void setMsg(List<SearchMsg> msg) {
        this.msg = msg;
    }

}
