package com.stark.geekbrains_edu.OpenWeatherModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Minutely {

    @SerializedName("dt")
    @Expose
    public Integer dt;
    @SerializedName("precipitation")
    @Expose
    public Integer precipitation;

    public Minutely withDt(Integer dt) {
        this.dt = dt;
        return this;
    }

    public Minutely withPrecipitation(Integer precipitation) {
        this.precipitation = precipitation;
        return this;
    }

}
