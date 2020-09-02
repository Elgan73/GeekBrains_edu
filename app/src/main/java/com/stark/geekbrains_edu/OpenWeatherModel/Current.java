package com.stark.geekbrains_edu.OpenWeatherModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Current {

    @SerializedName("dt")
    @Expose
    public Integer dt;
    @SerializedName("sunrise")
    @Expose
    public Integer sunrise;
    @SerializedName("sunset")
    @Expose
    public Integer sunset;
    @SerializedName("temp")
    @Expose
    public Float temp;
    @SerializedName("feels_like")
    @Expose
    public Float feelsLike;
    @SerializedName("pressure")
    @Expose
    public Integer pressure;
    @SerializedName("humidity")
    @Expose
    public Integer humidity;
    @SerializedName("dew_point")
    @Expose
    public Integer dewPoint;
    @SerializedName("uvi")
    @Expose
    public Float uvi;
    @SerializedName("clouds")
    @Expose
    public Integer clouds;
    @SerializedName("visibility")
    @Expose
    public Integer visibility;
    @SerializedName("wind_speed")
    @Expose
    public Integer windSpeed;
    @SerializedName("wind_deg")
    @Expose
    public Integer windDeg;
    @SerializedName("weather")
    @Expose
    public List<Weather_> weather = null;

    public Current withDt(Integer dt) {
        this.dt = dt;
        return this;
    }

    public Current withSunrise(Integer sunrise) {
        this.sunrise = sunrise;
        return this;
    }

    public Current withSunset(Integer sunset) {
        this.sunset = sunset;
        return this;
    }

    public Current withTemp(Float temp) {
        this.temp = temp;
        return this;
    }

    public Current withFeelsLike(Float feelsLike) {
        this.feelsLike = feelsLike;
        return this;
    }

    public Current withPressure(Integer pressure) {
        this.pressure = pressure;
        return this;
    }

    public Current withHumidity(Integer humidity) {
        this.humidity = humidity;
        return this;
    }

    public Current withDewPoint(Integer dewPoint) {
        this.dewPoint = dewPoint;
        return this;
    }

    public Current withUvi(Float uvi) {
        this.uvi = uvi;
        return this;
    }

    public Current withClouds(Integer clouds) {
        this.clouds = clouds;
        return this;
    }

    public Current withVisibility(Integer visibility) {
        this.visibility = visibility;
        return this;
    }

    public Current withWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
        return this;
    }

    public Current withWindDeg(Integer windDeg) {
        this.windDeg = windDeg;
        return this;
    }

    public Current withWeather(List<Weather_> weather) {
        this.weather = weather;
        return this;
    }

}
