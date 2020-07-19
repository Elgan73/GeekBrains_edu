package com.stark.geekbrains_edu.presentation.weather;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherPresenter {

    public String date() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return simpleDateFormat.format(date);
    }

//    public List<WeatherModel> setData() {
//
//    }

    public void getData() {

    }
}
