package com.stark.geekbrains_edu.presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.stark.geekbrains_edu.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Class classFragment;
        classFragment = GeneralFragment.class;
        replaceFragment(classFragment);
    }

    public void replaceFragment(Class classFragment){
        try {
            Fragment fragment = (Fragment) classFragment.newInstance();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frgmCont, fragment)
                    .addToBackStack("")
                    .commit();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}