package com.stark.geekbrains_edu.OpenWeatherModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rain {

    @SerializedName("1h")
    @Expose
    public Float _1h;

    public Rain with1h(Float _1h) {
        this._1h = _1h;
        return this;
    }

}
