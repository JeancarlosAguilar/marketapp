package com.example.marketapp;

import com.google.gson.annotations.SerializedName;

public class PopularModel {

    @SerializedName("id")
    private String idCategory;

    @SerializedName("name")
    private String nameCategory;

    @SerializedName("picture")
    private String imageCategory;

    public PopularModel() {
        super();
    }

    public PopularModel(String idCategory, String nameCategory, String imageCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.imageCategory = imageCategory;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getImageCategory() {
        return imageCategory;
    }

    public void setImageCategory(String imageCategory) {
        this.imageCategory = imageCategory;
    }
}
