
package com.example.localsewa.models.shopsbycategorymodels;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.example.localsewa.R;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

public class Msg {

    @SerializedName("restaurant_id")
    private String restaurantId;

    @SerializedName("restaurant_name")
    private String restaurantName;

    @SerializedName("restaurant_slogan")
    private String restaurantSlogan;

    @SerializedName("restaurant_about")
    private String restaurantAbout;

    @SerializedName("restaurant_fee")
    private String restaurantFee;

    @SerializedName("restaurant_image")
    private String restaurantImage;

    @SerializedName("restaurant_cover")
    private String restaurantCover;

    @SerializedName("restaurant_menu_style")
    private String restaurantMenuStyle;

    @SerializedName("restaurant_phone")
    private String restaurantPhone;

    @SerializedName("restaurant_currency")
    private String restaurantCurrency;

    @SerializedName("restaurant_tax")
    private Integer restaurantTax;

    @SerializedName("deliveryTime")
    private String deliveryTime;

    @SerializedName("delivery_fee_per_km")
    private String deliveryFeePerKm;

    @SerializedName("min_order_price")
    private String minOrderPrice;

    @SerializedName("preparation_time")
    private String preparationTime;

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantSlogan() {
        return restaurantSlogan;
    }

    public void setRestaurantSlogan(String restaurantSlogan) {
        this.restaurantSlogan = restaurantSlogan;
    }

    public String getRestaurantAbout() {
        return restaurantAbout;
    }

    public void setRestaurantAbout(String restaurantAbout) {
        this.restaurantAbout = restaurantAbout;
    }

    public String getRestaurantFee() {
        return restaurantFee;
    }

    public void setRestaurantFee(String restaurantFee) {
        this.restaurantFee = restaurantFee;
    }

    public String getRestaurantImage() {
        return restaurantImage;
    }

    public void setRestaurantImage(String restaurantImage) {
        this.restaurantImage = restaurantImage;
    }

    public String getRestaurantCover() {
        return restaurantCover;
    }

    public void setRestaurantCover(String restaurantCover) {
        this.restaurantCover = restaurantCover;
    }

    public String getRestaurantMenuStyle() {
        return restaurantMenuStyle;
    }

    public void setRestaurantMenuStyle(String restaurantMenuStyle) {
        this.restaurantMenuStyle = restaurantMenuStyle;
    }

    public String getRestaurantPhone() {
        return restaurantPhone;
    }

    public void setRestaurantPhone(String restaurantPhone) {
        this.restaurantPhone = restaurantPhone;
    }

    public String getRestaurantCurrency() {
        return restaurantCurrency;
    }

    public void setRestaurantCurrency(String restaurantCurrency) {
        this.restaurantCurrency = restaurantCurrency;
    }

    public Integer getRestaurantTax() {
        return restaurantTax;
    }

    public void setRestaurantTax(Integer restaurantTax) {
        this.restaurantTax = restaurantTax;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryFeePerKm() {
        return deliveryFeePerKm;
    }

    public void setDeliveryFeePerKm(String deliveryFeePerKm) {
        this.deliveryFeePerKm = deliveryFeePerKm;
    }

    public String getMinOrderPrice() {

        return ""+deliveryTime+" MIN |  " +minOrderPrice+" Min Order";
    }

    public void setMinOrderPrice(String minOrderPrice) {
        this.minOrderPrice = minOrderPrice;
    }

    public String getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    @BindingAdapter({"android:image"})
    public static void setImage(ImageView imageVieww, String url){
        Picasso.with(imageVieww.getContext()).load("http://67.225.220.215/mobileapp_api/"+url).placeholder(R.drawable.b).into(imageVieww);

    }

}
