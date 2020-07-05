package com.stark.geekbrains_edu.presentation.city;

public final class CityChangePresenter {
    private static CityChangePresenter instance = null;

    private static final Object syncObj = new Object();

    private String city;

    private CityChangePresenter(){
        city = "";
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
