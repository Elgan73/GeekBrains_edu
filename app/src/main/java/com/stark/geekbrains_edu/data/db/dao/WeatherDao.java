package com.stark.geekbrains_edu.data.db.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.stark.geekbrains_edu.data.db.Entity.EntityCity;

import java.util.List;

@Dao
public interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long setData(EntityCity entity);

    @Update
    void updateRow(EntityCity entity);

    @Delete
    void deleteCity(EntityCity entity);

    @Query("SELECT * FROM EntityCity")
    List<EntityCity> getData();

    @Query("SELECT city FROM EntityCity")
    String getCity();

    @Query("DELETE FROM EntityCity")
    void deleteAllData();

    @Query("SELECT COUNT() FROM EntityCity")
    long getCountCities();

}
