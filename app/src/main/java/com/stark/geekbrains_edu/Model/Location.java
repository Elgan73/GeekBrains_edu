package com.stark.geekbrains_edu.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("country")
    @Expose
    public String country;
    @SerializedName("region")
    @Expose
    public String region;
    @SerializedName("lat")
    @Expose
    public String lat;
    @SerializedName("lon")
    @Expose
    public String lon;
    @SerializedName("timezone_id")
    @Expose
    public String timezoneId;
    @SerializedName("localtime")
    @Expose
    public String localtime;
    @SerializedName("localtime_epoch")
    @Expose
    public Integer localtimeEpoch;
    @SerializedName("utc_offset")
    @Expose
    public String utcOffset;

    public Location withName(String name) {
        this.name = name;
        return this;
    }

    public Location withCountry(String country) {
        this.country = country;
        return this;
    }

    public Location withRegion(String region) {
        this.region = region;
        return this;
    }

    public Location withLat(String lat) {
        this.lat = lat;
        return this;
    }

    public Location withLon(String lon) {
        this.lon = lon;
        return this;
    }

    public Location withTimezoneId(String timezoneId) {
        this.timezoneId = timezoneId;
        return this;
    }

    public Location withLocaltime(String localtime) {
        this.localtime = localtime;
        return this;
    }

    public Location withLocaltimeEpoch(Integer localtimeEpoch) {
        this.localtimeEpoch = localtimeEpoch;
        return this;
    }

    public Location withUtcOffset(String utcOffset) {
        this.utcOffset = utcOffset;
        return this;
    }

}
