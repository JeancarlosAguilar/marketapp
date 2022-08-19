package com.example.marketapp.api_files.Garments;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GarmentsResponse {

    @SerializedName("results")
    private ArrayList<Garments> results;

    public ArrayList<Garments> getResults() {
        return results;
    }

    public void setResults(ArrayList<Garments> results) {
        this.results = results;
    }
}
