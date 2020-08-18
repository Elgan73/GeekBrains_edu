package com.stark.geekbrains_edu;

import android.app.Application;

import androidx.room.Room;

import com.stark.geekbrains_edu.data.db.WeatherDatabase;
import com.stark.geekbrains_edu.data.db.dao.WeatherDao;

public class App extends Application {

    private static App instance;

    private WeatherDatabase db;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        db = Room.databaseBuilder(
                getApplicationContext(),
                WeatherDatabase.class,
                "city_db")
                .allowMainThreadQueries()
                .build();
    }

    public WeatherDao getCityDao() {
        return db.getEntityDao();
    }
}
