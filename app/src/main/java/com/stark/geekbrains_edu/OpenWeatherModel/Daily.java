package com.stark.geekbrains_edu.OpenWeatherModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Daily {

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
    public Temp temp;
    @SerializedName("feels_like")
    @Expose
    public FeelsLike feelsLike;
    @SerializedName("pressure")
    @Expose
    public Integer pressure;
    @SerializedName("humidity")
    @Expose
    public Integer humidity;
    @SerializedName("dew_point")
    @Expose
    public Float dewPoint;
    @SerializedName("wind_speed")
    @Expose
    public Float windSpeed;
    @SerializedName("wind_deg")
    @Expose
    public Integer windDeg;
    @SerializedName("weather")
    @Expose
    public List<Weather___> weather = null;
    @SerializedName("clouds")
    @Expose
    public Integer clouds;
    @SerializedName("pop")
    @Expose
    public Integer pop;
    @SerializedName("rain")
    @Expose
    public Float rain;
    @SerializedName("uvi")
    @Expose
    public Float uvi;

    public Daily withDt(Integer dt) {
        this.dt = dt;
        return this;
    }

    public Daily withSunrise(Integer sunrise) {
        this.sunrise = sunrise;
        return this;
    }

    public Daily withSunset(Integer sunset) {
        this.sunset = sunset;
        return this;
    }

    public Daily withTemp(Temp temp) {
        this.temp = temp;
        return this;
    }

    public Daily withFeelsLike(FeelsLike feelsLike) {
        this.feelsLike = feelsLike;
        return this;
    }

    public Daily withPressure(Integer pressure) {
        this.pressure = pressure;
        return this;
    }

    public Daily withHumidity(Integer humidity) {
        this.humidity = humidity;
        return this;
    }

    public Daily withDewPoint(Float dewPoint) {
        this.dewPoint = dewPoint;
        return this;
    }

    public Daily withWindSpeed(Float windSpeed) {
        this.windSpeed = windSpeed;
        return this;
    }

    public Daily withWindDeg(Integer windDeg) {
        this.windDeg = windDeg;
        return this;
    }

    public Daily withWeather(List<Weather___> weather) {
        this.weather = weather;
        return this;
    }

    public Daily withClouds(Integer clouds) {
        this.clouds = clouds;
        return this;
    }

    public Daily withPop(Integer pop) {
        this.pop = pop;
        return this;
    }

    public Daily withRain(Float rain) {
        this.rain = rain;
        return this;
    }

    public Daily withUvi(Float uvi) {
        this.uvi = uvi;
        return this;
    }

}
