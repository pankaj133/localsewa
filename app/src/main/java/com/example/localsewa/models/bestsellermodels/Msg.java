
package com.example.localsewa.models.bestsellermodels;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import java.util.List;

import com.example.localsewa.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class Msg {

    @SerializedName("0")
    @Expose
    private _0 _0;
    @SerializedName("Restaurant")
    @Expose
    private Restaurant restaurant;
    @SerializedName("UserInfo")
    @Expose
    private UserInfo userInfo;
    @SerializedName("RestaurantLocation")
    @Expose
    private RestaurantLocation restaurantLocation;
    @SerializedName("Currency")
    @Expose
    private Currency currency;
    @SerializedName("Tax")
    @Expose
    private Tax tax;
    @SerializedName("RestaurantFavourite")
    @Expose
    private RestaurantFavourite restaurantFavourite;
    @SerializedName("User")
    @Expose
    private User user;
    @SerializedName("RestaurantTiming")
    @Expose
    private List<RestaurantTiming> restaurantTiming = null;
    @SerializedName("RestaurantRating")
    @Expose
    private List<RestaurantRating> restaurantRating = null;
    @SerializedName("TotalRatings")
    @Expose
    private TotalRatings totalRatings;

    public _0 get0() {
        return _0;
    }

    public void set0(_0 _0) {
        this._0 = _0;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public RestaurantLocation getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(RestaurantLocation restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public RestaurantFavourite getRestaurantFavourite() {
        return restaurantFavourite;
    }

    public void setRestaurantFavourite(RestaurantFavourite restaurantFavourite) {
        this.restaurantFavourite = restaurantFavourite;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<RestaurantTiming> getRestaurantTiming() {
        return restaurantTiming;
    }

    public void setRestaurantTiming(List<RestaurantTiming> restaurantTiming) {
        this.restaurantTiming = restaurantTiming;
    }

    public List<RestaurantRating> getRestaurantRating() {
        return restaurantRating;
    }

    public void setRestaurantRating(List<RestaurantRating> restaurantRating) {
        this.restaurantRating = restaurantRating;
    }

    public TotalRatings getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(TotalRatings totalRatings) {
        this.totalRatings = totalRatings;
    }


    @BindingAdapter({"android:image"})
    public static void setImageView(ImageView imageVieww, String url)
    {
        Picasso.with(imageVieww.getContext()).load("http://67.225.220.215/mobileapp_api/"+url).placeholder(R.drawable.a).into(imageVieww);
    }


}
