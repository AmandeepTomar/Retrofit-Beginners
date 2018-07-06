package com.vnibin.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {

    @SerializedName("worldpopulation")
    @Expose
    private List<WorldPopulation> worldpopulation = null;

    public List<WorldPopulation> getWorldpopulation() {
        return worldpopulation;
    }

    public void setWorldpopulation(List<WorldPopulation> worldpopulation) {
        this.worldpopulation = worldpopulation;
    }

}
