package com.stark.geekbrains_edu.data.net;

import com.stark.geekbrains_edu.Model.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherStackApi {
    @GET("current")
    Call<Weather> loadData(@Query("access_key") String appKey, @Query("query") String city);
}
