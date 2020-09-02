package com.stark.geekbrains_edu.data.net;


import com.stark.geekbrains_edu.OpenWeatherModel.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherMapApi {

    @GET("data/2.5/onecall")
    Call<Weather> loadData(@Query("lat") String lat, @Query("lon") String lon, @Query("appid") String appId);
}


// https://api.openweathermap.org/data/2.5/onecall?lat=54.1851&lon=48.2412&%20exclude=hourly,daily&appid=10fb02d979056b47ecc2dd5eb31598ca