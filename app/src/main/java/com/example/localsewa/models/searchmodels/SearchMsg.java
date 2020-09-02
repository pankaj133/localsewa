package com.example.localsewa.models.searchmodels;

import com.google.gson.annotations.SerializedName;

public class SearchMsg {

    @SerializedName("restaurant_name")
    private String restaurantName;

    @SerializedName("item")
    private String item;

    @SerializedName("item_image")
    private String itemImage;

    @SerializedName("price")
    private String price;

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getPrice() {
        return "₹ "+price+"";
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
