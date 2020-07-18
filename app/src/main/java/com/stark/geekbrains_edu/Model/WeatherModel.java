package com.stark.geekbrains_edu.Model;

public class WeatherModel {

    private int temperature;
    private String city;
    private int humidity;
    private double windSpeed;
    private boolean celsius;
    private int imageView;
    private String date;

    public WeatherModel() {};

    public WeatherModel(int temperature, int humidity, double windSpeed, boolean celsius, int imageView, String date) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.celsius = celsius;
        this.imageView = imageView;
        this.date = date;
    }

    public WeatherModel(int temperature, String city, int humidity, double windSpeed, boolean celsius, int imageView, String date) {
        this.temperature = temperature;
        this.city = city;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.celsius = celsius;
        this.imageView = imageView;
        this.date = date;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public boolean isCelsius() {
        return celsius;
    }

    public void setCelsius(boolean celsius) {
        this.celsius = celsius;
    }

    @Override
    public String toString() {
        return "WeatherModel{" +
                "temperature=" + temperature +
                ", city='" + city + '\'' +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", celsius=" + celsius +
                ", imageView=" + imageView +
                ", date='" + date + '\'' +
                '}';
    }
}
