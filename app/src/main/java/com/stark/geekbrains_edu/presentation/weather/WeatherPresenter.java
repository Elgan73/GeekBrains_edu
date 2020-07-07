package com.stark.geekbrains_edu.presentation.weather;

import android.annotation.SuppressLint;
import android.net.Uri;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherPresenter {

    private static WeatherPresenter instance = null;
    private String[] tempCol;
    private String city;
    private float windSpeed;
    private Uri imageLink;
    private String date;

    public WeatherPresenter(String[] tempCol, String city, float windSpeed, Uri imageLink, String date) {
        this.tempCol = tempCol;
        this.city = city;
        this.windSpeed = windSpeed;
        this.imageLink = imageLink;
        this.date = date;
    }

    public WeatherPresenter() {}

    public String[] getTempCol() {
        return tempCol;
    }

    public void setTempCol(String[] tempCol) {
        this.tempCol = tempCol;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Uri getImageLink() {
        return imageLink;
    }

    public void setImageLink(Uri imageLink) {
        this.imageLink = imageLink;
    }

    public String getDate() {
                @SuppressLint("SimpleDateFormat")
                SimpleDateFormat format = new SimpleDateFormat(" hh:mm  dd.MM.yyyy");
                date = format.format(new Date());

        return date;
    }


    public static WeatherPresenter getInstance() {
        instance = instance != null ? instance : new WeatherPresenter();
        return instance;
    }
}
