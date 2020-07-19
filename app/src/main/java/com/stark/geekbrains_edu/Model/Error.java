package com.stark.geekbrains_edu.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Error {

    @SerializedName("code")
    @Expose
    public Integer code;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("info")
    @Expose
    public String info;

    public Error withCode(Integer code) {
        this.code = code;
        return this;
    }

    public Error withType(String type) {
        this.type = type;
        return this;
    }

    public Error withInfo(String info) {
        this.info = info;
        return this;
    }

}