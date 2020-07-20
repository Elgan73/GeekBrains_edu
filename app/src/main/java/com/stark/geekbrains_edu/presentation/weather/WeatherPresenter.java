package com.stark.geekbrains_edu.presentation.weather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherPresenter {

    public String date() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return simpleDateFormat.format(date);
    }

    public void navigate(FragmentManager fm, Integer container, Fragment fragment, String str) {
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(container, fragment);
        Bundle bundle = new Bundle();
        bundle.putString("CITY", str);
        fragment.setArguments(bundle);
        ft.addToBackStack("");
        ft.commit();
    }
}
