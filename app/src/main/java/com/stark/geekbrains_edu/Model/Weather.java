package com.stark.geekbrains_edu.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("request")
    @Expose
    public Request request;
    @SerializedName("location")
    @Expose
    public Location location;
    @SerializedName("current")
    @Expose
    public Current current;
    @SerializedName("success")
    @Expose
    public Boolean success;
    @SerializedName("error")
    @Expose
    public Error error;

    public Weather withRequest(Request request) {
        this.request = request;
        return this;
    }

    public Weather withLocation(Location location) {
        this.location = location;
        return this;
    }

    public Weather withCurrent(Current current) {
        this.current = current;
        return this;
    }

    public Weather withSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public Weather withError(Error error) {
        this.error = error;
        return this;
    }

}
