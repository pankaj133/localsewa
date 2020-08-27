
package com.example.localsewa.models.bestsellermodels;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.example.localsewa.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class Restaurant {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slogan")
    @Expose
    private String slogan;
    @SerializedName("about")
    @Expose
    private String about;
    @SerializedName("speciality")
    @Expose
    private String speciality;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("menu_style")
    @Expose
    private String menuStyle;
    @SerializedName("promoted")
    @Expose
    private String promoted;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("preparation_time")
    @Expose
    private String preparationTime;
    @SerializedName("min_order_price")
    @Expose
    private String minOrderPrice;
    @SerializedName("delivery_free_range")
    @Expose
    private String deliveryFreeRange;
    @SerializedName("currency_id")
    @Expose
    private String currencyId;
    @SerializedName("tax_id")
    @Expose
    private String taxId;
    @SerializedName("tax_free")
    @Expose
    private String taxFree;
    @SerializedName("cover_image")
    @Expose
    private String coverImage;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("added_by")
    @Expose
    private String addedBy;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("google_analytics")
    @Expose
    private String googleAnalytics;
    @SerializedName("block")
    @Expose
    private String block;
    @SerializedName("single_restaurant")
    @Expose
    private String singleRestaurant;
    @SerializedName("admin_commission")
    @Expose
    private String adminCommission;
    @SerializedName("loc_id")
    @Expose
    private String locId;
    @SerializedName("loc_city_id")
    @Expose
    private String locCityId;
    @SerializedName("cat_id")
    @Expose
    private String catId;
    @SerializedName("favourite")
    @Expose
    private String favourite;
    @SerializedName("delivery_fee")
    @Expose
    private String deliveryFee;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getSpeciality() {
        return "("+speciality+")";
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getMenuStyle() {
        return menuStyle;
    }

    public void setMenuStyle(String menuStyle) {
        this.menuStyle = menuStyle;
    }

    public String getPromoted() {
        return promoted;
    }

    public void setPromoted(String promoted) {
        this.promoted = promoted;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getMinOrderPrice() {
        return minOrderPrice;
    }

    public void setMinOrderPrice(String minOrderPrice) {
        this.minOrderPrice = minOrderPrice;
    }

    public String getDeliveryFreeRange() {
        return deliveryFreeRange;
    }

    public void setDeliveryFreeRange(String deliveryFreeRange) {
        this.deliveryFreeRange = deliveryFreeRange;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getTaxFree() {
        return taxFree;
    }

    public void setTaxFree(String taxFree) {
        this.taxFree = taxFree;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getGoogleAnalytics() {
        return googleAnalytics;
    }

    public void setGoogleAnalytics(String googleAnalytics) {
        this.googleAnalytics = googleAnalytics;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getSingleRestaurant() {
        return singleRestaurant;
    }

    public void setSingleRestaurant(String singleRestaurant) {
        this.singleRestaurant = singleRestaurant;
    }

    public String getAdminCommission() {
        return adminCommission;
    }

    public void setAdminCommission(String adminCommission) {
        this.adminCommission = adminCommission;
    }

    public String getLocId() {
        return locId;
    }

    public void setLocId(String locId) {
        this.locId = locId;
    }

    public String getLocCityId() {
        return locCityId;
    }

    public void setLocCityId(String locCityId) {
        this.locCityId = locCityId;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getFavourite() {
        return favourite;
    }

    public void setFavourite(String favourite) {
        this.favourite = favourite;
    }

    public String getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(String deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

}
