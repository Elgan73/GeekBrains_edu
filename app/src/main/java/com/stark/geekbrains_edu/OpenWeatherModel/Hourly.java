package com.stark.geekbrains_edu.OpenWeatherModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hourly {

    @SerializedName("dt")
    @Expose
    public Integer dt;
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
    public Float dewPoint;
    @SerializedName("clouds")
    @Expose
    public Integer clouds;
    @SerializedName("visibility")
    @Expose
    public Integer visibility;
    @SerializedName("wind_speed")
    @Expose
    public Float windSpeed;
    @SerializedName("wind_deg")
    @Expose
    public Integer windDeg;
    @SerializedName("weather")
    @Expose
    public List<Weather__> weather = null;
    @SerializedName("pop")
    @Expose
    public Integer pop;
    @SerializedName("rain")
    @Expose
    public Rain rain;

    public Hourly withDt(Integer dt) {
        this.dt = dt;
        return this;
    }

    public Hourly withTemp(Float temp) {
        this.temp = temp;
        return this;
    }

    public Hourly withFeelsLike(Float feelsLike) {
        this.feelsLike = feelsLike;
        return this;
    }

    public Hourly withPressure(Integer pressure) {
        this.pressure = pressure;
        return this;
    }

    public Hourly withHumidity(Integer humidity) {
        this.humidity = humidity;
        return this;
    }

    public Hourly withDewPoint(Float dewPoint) {
        this.dewPoint = dewPoint;
        return this;
    }

    public Hourly withClouds(Integer clouds) {
        this.clouds = clouds;
        return this;
    }

    public Hourly withVisibility(Integer visibility) {
        this.visibility = visibility;
        return this;
    }

    public Hourly withWindSpeed(Float windSpeed) {
        this.windSpeed = windSpeed;
        return this;
    }

    public Hourly withWindDeg(Integer windDeg) {
        this.windDeg = windDeg;
        return this;
    }

    public Hourly withWeather(List<Weather__> weather) {
        this.weather = weather;
        return this;
    }

    public Hourly withPop(Integer pop) {
        this.pop = pop;
        return this;
    }

    public Hourly withRain(Rain rain) {
        this.rain = rain;
        return this;
    }

}
