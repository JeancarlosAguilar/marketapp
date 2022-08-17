package com.example.marketapp;

import java.util.List;

public class PopularResponse {

    private PopularModel popularModel;

    private List<PopularModel> popularModelList;

    public List<PopularModel> getPopularModelList() {
        return popularModelList;
    }

    public void setPopularModelList(List<PopularModel> popularModelList) {
        this.popularModelList = popularModelList;
    }

    public PopularModel getPopularModel() {
        return popularModel;
    }

    public void setPopularModel(PopularModel popularModel) {
        this.popularModel = popularModel;
    }
}
