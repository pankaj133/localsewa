
package com.example.localsewa.models.bestsellermodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TotalRatings {

    @SerializedName("avg")
    private String avg;

    @SerializedName("totalRatings")
    private String totalRatings;

    public float getAvg() {
        return Float.parseFloat(avg);
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
