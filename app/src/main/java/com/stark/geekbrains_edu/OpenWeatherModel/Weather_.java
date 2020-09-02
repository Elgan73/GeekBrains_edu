package com.stark.geekbrains_edu.OpenWeatherModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather_ {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("main")
    @Expose
    public String main;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("icon")
    @Expose
    public String icon;

    public Weather_ withId(Integer id) {
        this.id = id;
        return this;
    }

    public Weather_ withMain(String main) {
        this.main = main;
        return this;
    }

    public Weather_ withDescription(String description) {
        this.description = description;
        return this;
    }

    public Weather_ withIcon(String icon) {
        this.icon = icon;
        return this;
    }

}
