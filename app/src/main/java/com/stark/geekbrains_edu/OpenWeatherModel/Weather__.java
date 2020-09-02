package com.stark.geekbrains_edu.OpenWeatherModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather__ {

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

    public Weather__ withId(Integer id) {
        this.id = id;
        return this;
    }

    public Weather__ withMain(String main) {
        this.main = main;
        return this;
    }

    public Weather__ withDescription(String description) {
        this.description = description;
        return this;
    }

    public Weather__ withIcon(String icon) {
        this.icon = icon;
        return this;
    }

}
