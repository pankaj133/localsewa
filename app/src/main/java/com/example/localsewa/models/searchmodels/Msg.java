
package com.example.localsewa.models.searchmodels;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.example.localsewa.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

public class Msg {

    @SerializedName("restaurant_id")
    @Expose
    private String restaurantId;
    @SerializedName("restaurant_name")
    @Expose
    private String restaurantName;
    @SerializedName("restaurant_slogan")
    @Expose
    private String restaurantSlogan;
    @SerializedName("restaurant_about")
    @Expose
    private String restaurantAbout;
    @SerializedName("restaurant_fee")
    @Expose
    private String restaurantFee;
    @SerializedName("restaurant_image")
    @Expose
    private String restaurantImage;
    @SerializedName("restaurant_cover")
    @Expose
    private String restaurantCover;
    @SerializedName("restaurant_menu_style")
    @Expose
    private String restaurantMenuStyle;
    @SerializedName("restaurant_phone")
    @Expose
    private String restaurantPhone;
    @SerializedName("restaurant_currency")
    @Expose
    private String restaurantCurrency;
    @SerializedName("restaurant_tax")
    @Expose
    private String restaurantTax;
    @SerializedName("deliveryTime")
    @Expose
    private String deliveryTime;
    @SerializedName("delivery_fee_per_km")
    @Expose
    private String deliveryFeePerKm;
    @SerializedName("min_order_price")
    @Expose
    private String minOrderPrice;
    @SerializedName("preparation_time")
    @Expose
    private String preparationTime;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("item_id")
    @Expose
    private String itemId;
    @SerializedName("item")
    @Expose
    private String item;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("item_image")
    @Expose
    private Object itemImage;
    @SerializedName("price")
    @Expose
    private String price;

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

    public String getRestaurantTax() {
        return restaurantTax;
    }

    public void setRestaurantTax(String restaurantTax) {
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
        return minOrderPrice;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getItemImage() {
        return itemImage;
    }

    public void setItemImage(Object itemImage) {
        this.itemImage = itemImage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @BindingAdapter("android:src")
    public static void setImageViewResource(ImageView imageViewResource ,String url){

        Picasso.with(imageViewResource.getContext()).load(
                "http://67.225.220.215/mobileapp_api/"+url).placeholder(R.drawable.a).into(imageViewResource);

    }


}
