package com.stark.geekbrains_edu.presentation;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainPresenter {

    public void onStart(FragmentManager fm, Integer container, Fragment fragment) {
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(container, fragment);
        ft.commit();
    }
}
