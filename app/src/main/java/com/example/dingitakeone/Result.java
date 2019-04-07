package com.example.dingitakeone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("score")
    @Expose
    private String score;

    @SerializedName("location")
    @Expose
    private List<Double> location;

    public Result(String name, String score, List<Double> location) {
        this.name = name;
        this.score = score;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }

    public List<Double> getLocation() {
        return location;
    }
}
