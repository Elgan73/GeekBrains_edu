package com.stark.geekbrains_edu.net;

import com.stark.geekbrains_edu.Model.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("current?access_key=00138a6a0ccff95b3b1e1064f3f9b25c")
    Call<Weather> loadData(@Query("query") String city);

}
