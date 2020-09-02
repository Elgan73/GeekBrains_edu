package com.stark.geekbrains_edu.repo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Repository {

    final String API_KEY = "00138a6a0ccff95b3b1e1064f3f9b25c";


    public BufferedReader getJson(String city) {
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


}
