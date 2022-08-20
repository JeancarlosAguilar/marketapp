package com.example.marketapp.api_files.seach;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SearchResponse {

    @SerializedName("results")
    private ArrayList<Search> results;

    public ArrayList<Search> getResults() {
        return results;
    }

    public void setResults(ArrayList<Search> results) {
        this.results = results;
    }

}
