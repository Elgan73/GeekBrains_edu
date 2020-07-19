package com.stark.geekbrains_edu.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Current {

    @SerializedName("observation_time")
    @Expose
    public String observationTime;
    @SerializedName("temperature")
    @Expose
    public Integer temperature;
    @SerializedName("weather_code")
    @Expose
    public Integer weatherCode;
    @SerializedName("weather_icons")
    @Expose
    public List<String> weatherIcons = null;
    @SerializedName("weather_descriptions")
    @Expose
    public List<String> weatherDescriptions = null;
    @SerializedName("wind_speed")
    @Expose
    public Integer windSpeed;
    @SerializedName("wind_degree")
    @Expose
    public Integer windDegree;
    @SerializedName("wind_dir")
    @Expose
    public String windDir;
    @SerializedName("pressure")
    @Expose
    public Integer pressure;
    @SerializedName("precip")
    @Expose
    public Float precip;
    @SerializedName("humidity")
    @Expose
    public Integer humidity;
    @SerializedName("cloudcover")
    @Expose
    public Integer cloudcover;
    @SerializedName("feelslike")
    @Expose
    public Integer feelslike;
    @SerializedName("uv_index")
    @Expose
    public Integer uvIndex;
    @SerializedName("visibility")
    @Expose
    public Integer visibility;
    @SerializedName("is_day")
    @Expose
    public String isDay;

    public Current withObservationTime(String observationTime) {
        this.observationTime = observationTime;
        return this;
    }

    public Current withTemperature(Integer temperature) {
        this.temperature = temperature;
        return this;
    }

    public Current withWeatherCode(Integer weatherCode) {
        this.weatherCode = weatherCode;
        return this;
    }

    public Current withWeatherIcons(List<String> weatherIcons) {
        this.weatherIcons = weatherIcons;
        return this;
    }

    public Current withWeatherDescriptions(List<String> weatherDescriptions) {
        this.weatherDescriptions = weatherDescriptions;
        return this;
    }

    public Current withWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
        return this;
    }

    public Current withWindDegree(Integer windDegree) {
        this.windDegree = windDegree;
        return this;
    }

    public Current withWindDir(String windDir) {
        this.windDir = windDir;
        return this;
    }

    public Current withPressure(Integer pressure) {
        this.pressure = pressure;
        return this;
    }

    public Current withPrecip(Float precip) {
        this.precip = precip;
        return this;
    }

    public Current withHumidity(Integer humidity) {
        this.humidity = humidity;
        return this;
    }

    public Current withCloudcover(Integer cloudcover) {
        this.cloudcover = cloudcover;
        return this;
    }

    public Current withFeelslike(Integer feelslike) {
        this.feelslike = feelslike;
        return this;
    }

    public Current withUvIndex(Integer uvIndex) {
        this.uvIndex = uvIndex;
        return this;
    }

    public Current withVisibility(Integer visibility) {
        this.visibility = visibility;
        return this;
    }

    public Current withIsDay(String isDay) {
        this.isDay = isDay;
        return this;
    }

}
