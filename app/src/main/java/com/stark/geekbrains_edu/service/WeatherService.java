package com.stark.geekbrains_edu.service;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class WeatherService extends Service {
    final String API_KEY = "00138a6a0ccff95b3b1e1064f3f9b25c";

    private final IBinder binder = new ServiceBinder();


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("SERVICE_BIND: ", "Service started");

        return binder;
    }


    public BufferedReader getData(String city) {
        HttpURLConnection connection;
        BufferedReader in = null;
        try{
            URL link = new URL("http://api.weatherstack.com/current?access_key=" + API_KEY + "&query=" + city);
            connection = (HttpURLConnection)link.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (MalformedURLException | ProtocolException m) {
            System.out.println(m.getLocalizedMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return in;
    }

    public class ServiceBinder extends Binder {

        WeatherService getService(){ return WeatherService.this;}
        public BufferedReader getWeatherData(String city) {
            return getService().getData(city);
        }
    }
}
