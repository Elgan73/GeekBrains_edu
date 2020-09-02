package com.stark.geekbrains_edu.OpenWeatherModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather {

    @SerializedName("lat")
    @Expose
    public Float lat;
    @SerializedName("lon")
    @Expose
    public Float lon;
    @SerializedName("timezone")
    @Expose
    public String timezone;
    @SerializedName("timezone_offset")
    @Expose
    public Integer timezoneOffset;
    @SerializedName("current")
    @Expose
    public Current current;
    @SerializedName("minutely")
    @Expose
    public List<Minutely> minutely = null;
    @SerializedName("hourly")
    @Expose
    public List<Hourly> hourly = null;
    @SerializedName("daily")
    @Expose
    public List<Daily> daily = null;

    public Weather withLat(Float lat) {
        this.lat = lat;
        return this;
    }

    public Weather withLon(Float lon) {
        this.lon = lon;
        return this;
    }

    public Weather withTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    public Weather withTimezoneOffset(Integer timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
        return this;
    }

    public Weather withCurrent(Current current) {
        this.current = current;
        return this;
    }

    public Weather withMinutely(List<Minutely> minutely) {
        this.minutely = minutely;
        return this;
    }

    public Weather withHourly(List<Hourly> hourly) {
        this.hourly = hourly;
        return this;
    }

    public Weather withDaily(List<Daily> daily) {
        this.daily = daily;
        return this;
    }

}
