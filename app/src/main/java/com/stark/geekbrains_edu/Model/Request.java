package com.stark.geekbrains_edu.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {

    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("query")
    @Expose
    public String query;
    @SerializedName("language")
    @Expose
    public String language;
    @SerializedName("unit")
    @Expose
    public String unit;

    public Request withType(String type) {
        this.type = type;
        return this;
    }

    public Request withQuery(String query) {
        this.query = query;
        return this;
    }

    public Request withLanguage(String language) {
        this.language = language;
        return this;
    }

    public Request withUnit(String unit) {
        this.unit = unit;
        return this;
    }

}
