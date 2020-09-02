package com.stark.geekbrains_edu.OpenWeatherModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Temp {

    @SerializedName("day")
    @Expose
    public Float day;
    @SerializedName("min")
    @Expose
    public Float min;
    @SerializedName("max")
    @Expose
    public Float max;
    @SerializedName("night")
    @Expose
    public Float night;
    @SerializedName("eve")
    @Expose
    public Float eve;
    @SerializedName("morn")
    @Expose
    public Float morn;

    public Temp withDay(Float day) {
        this.day = day;
        return this;
    }

    public Temp withMin(Float min) {
        this.min = min;
        return this;
    }

    public Temp withMax(Float max) {
        this.max = max;
        return this;
    }

    public Temp withNight(Float night) {
        this.night = night;
        return this;
    }

    public Temp withEve(Float eve) {
        this.eve = eve;
        return this;
    }

    public Temp withMorn(Float morn) {
        this.morn = morn;
        return this;
    }

}
