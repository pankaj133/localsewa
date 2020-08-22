
package com.example.localsewa.models.bestsellermodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurantFavourite {

    @SerializedName("id")
    @Expose
    private Object id;
    @SerializedName("restaurant_id")
    @Expose
    private Object restaurantId;
    @SerializedName("user_id")
    @Expose
    private Object userId;
    @SerializedName("favourite")
    @Expose
    private Object favourite;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Object restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    public Object getFavourite() {
        return favourite;
    }

    public void setFavourite(Object favourite) {
        this.favourite = favourite;
    }

}
