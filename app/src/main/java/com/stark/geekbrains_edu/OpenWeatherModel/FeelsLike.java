package com.stark.geekbrains_edu.OpenWeatherModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeelsLike {

    @SerializedName("day")
    @Expose
    public Float day;
    @SerializedName("night")
    @Expose
    public Float night;
    @SerializedName("eve")
    @Expose
    public Float eve;
    @SerializedName("morn")
    @Expose
    public Float morn;

    public FeelsLike withDay(Float day) {
        this.day = day;
        return this;
    }

    public FeelsLike withNight(Float night) {
        this.night = night;
        return this;
    }

    public FeelsLike withEve(Float eve) {
        this.eve = eve;
        return this;
    }

    public FeelsLike withMorn(Float morn) {
        this.morn = morn;
        return this;
    }

}

