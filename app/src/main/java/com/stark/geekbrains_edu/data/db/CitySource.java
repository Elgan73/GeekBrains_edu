package com.stark.geekbrains_edu.data.db;

import com.stark.geekbrains_edu.data.db.Entity.EntityCity;
import com.stark.geekbrains_edu.data.db.dao.WeatherDao;

import java.util.List;

public class CitySource {
    private final WeatherDao weatherDao;

    private List<EntityCity> cities;

    public CitySource(WeatherDao weatherDao) {
        this.weatherDao = weatherDao;
    }

    public List<EntityCity> getCities() {
        if(cities == null) {
            loadData();
        }
        return cities;
    }

    public void loadData() {
        cities = weatherDao.getData();
    }

    public long getCountCities() {
        return weatherDao.getCountCities();
    }

    public void setNewCity(EntityCity entityCity) {
        weatherDao.setData(entityCity);
        loadData();
    }

    public void deleteCity(EntityCity entityCity) {
        weatherDao.deleteCity(entityCity);
        loadData();
    }



}
