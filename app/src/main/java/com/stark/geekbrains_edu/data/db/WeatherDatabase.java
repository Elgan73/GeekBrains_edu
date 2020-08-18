package com.stark.geekbrains_edu.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.stark.geekbrains_edu.data.db.Entity.EntityCity;
import com.stark.geekbrains_edu.data.db.dao.WeatherDao;


@Database(entities = {EntityCity.class}, version = 1, exportSchema = false)
public abstract class WeatherDatabase extends RoomDatabase {
    public abstract WeatherDao getEntityDao();
}
