package com.stark.geekbrains_edu.presentation.StartScreen;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class StartPresenter {

    public void navigate(FragmentManager fm, Integer container, Fragment fragment) {
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(container, fragment);
        ft.addToBackStack("");
        ft.commit();
    }

}
