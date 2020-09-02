package com.stark.geekbrains_edu.data.net;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OpenRetrofit {
    final String BASE_URL = "https://api.openweathermap.org/";

    public Retrofit retrofit() {
        Retrofit retrofit;
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
