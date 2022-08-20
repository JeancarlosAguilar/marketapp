package com.example.marketapp.api_files.garments;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Garments implements Serializable {

    @SerializedName("title")
    private String title;

    @SerializedName("thumbnail")
    private String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
