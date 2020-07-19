package com.stark.geekbrains_edu.presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.stark.geekbrains_edu.R;
import com.stark.geekbrains_edu.presentation.city.CityFragment;

public class MainActivity extends AppCompatActivity {

    MainPresenter mainPresenter = new MainPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter.onStart(getSupportFragmentManager(), R.id.frgmCont, new CityFragment());
//        BottomNavigationView bnm = findViewById(R.id.bottomNavMenu);
//        bnm.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.city:
//                        CityFragment cityChangeFragment = new CityFragment();
//                        mainPresenter.onStart(getSupportFragmentManager(), R.id.frgmCont, cityChangeFragment);
//                        break;
//                    case R.id.weather:
//                        WeatherFragment weatherFragment = new WeatherFragment();
//                        mainPresenter.onStart(getSupportFragmentManager(), R.id.frgmCont, weatherFragment);
//                        break;
//                }
//                return false;
//            }
//        });


    }


}