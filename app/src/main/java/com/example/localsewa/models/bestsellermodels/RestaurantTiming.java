
package com.example.localsewa.models.bestsellermodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurantTiming {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("opening_time")
    @Expose
    private String openingTime;
    @SerializedName("closing_time")
    @Expose
    private String closingTime;
    @SerializedName("restaurant_id")
    @Expose
    private String restaurantId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

}
