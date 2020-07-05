package com.stark.geekbrains_edu.presentation.city;

public final class CityChangePresenter {
    private static CityChangePresenter instance = null;

    private static final Object syncObj = new Object();

    private String city;
    private boolean celsFahr;
    private boolean humidity;

    public boolean isHumidity() {
        return humidity;
    }

    public void setHumidity(boolean humidity) {
        this.humidity = humidity;
    }

    public boolean isWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(boolean windSpeed) {
        this.windSpeed = windSpeed;
    }

    private boolean windSpeed;

    private CityChangePresenter(){
        city = "";
    }

    public boolean isCelsFahr() {
        return celsFahr;
    }

    public void setCelsFahr(boolean celsFahr) {
        this.celsFahr = celsFahr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static CityChangePresenter getInstance() {
         instance = instance != null ? instance : new CityChangePresenter();
            return instance;

    }


}
