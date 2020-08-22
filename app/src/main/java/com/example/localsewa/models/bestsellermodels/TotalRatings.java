
package com.example.localsewa.models.bestsellermodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TotalRatings {

    @SerializedName("avg")
    @Expose
    private String avg;
    @SerializedName("totalRatings")
    @Expose
    private String totalRatings;

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    public String getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(String totalRatings) {
        this.totalRatings = totalRatings;
    }

}
