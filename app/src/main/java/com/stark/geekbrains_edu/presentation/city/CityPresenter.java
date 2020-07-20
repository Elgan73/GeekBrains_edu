package com.stark.geekbrains_edu.presentation.city;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class CityPresenter {

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
