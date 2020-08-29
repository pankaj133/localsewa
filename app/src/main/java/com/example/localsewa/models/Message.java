package com.example.localsewa.models;


import androidx.databinding.BindingAdapter;
import com.example.localsewa.R;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;
import de.hdodenhof.circleimageview.CircleImageView;

public class Message {


    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("image")
    private String image;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @BindingAdapter({"image_url"})
    public static void loadImage(CircleImageView imageView, String url)
    {
        Picasso.with(imageView.getContext()).load(url).placeholder(R.drawable.d).into(imageView);
    }

}
