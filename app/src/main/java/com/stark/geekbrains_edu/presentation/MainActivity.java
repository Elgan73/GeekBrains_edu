package com.stark.geekbrains_edu.presentation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.stark.geekbrains_edu.Model.WeatherModel;
import com.stark.geekbrains_edu.R;
import com.stark.geekbrains_edu.presentation.city.CityFragment;
import com.stark.geekbrains_edu.presentation.weather.WeatherFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainPresenter mainPresenter = new MainPresenter();
    List<WeatherModel> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter.onStart(getSupportFragmentManager(), R.id.frgmCont, new CityFragment());
//        setInitialData();
        BottomNavigationView bnm = findViewById(R.id.bottomNavMenu);
        bnm.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.city:
                        CityFragment cityChangeFragment = new CityFragment();
                        mainPresenter.onStart(getSupportFragmentManager(), R.id.frgmCont, cityChangeFragment);
                        break;
                    case R.id.weather:
                        WeatherFragment weatherFragment = new WeatherFragment();
                        mainPresenter.onStart(getSupportFragmentManager(), R.id.frgmCont, weatherFragment);
                        break;
                }
                return false;
            }
        });


    }

//    private void setInitialData() {
//        models.add(new WeatherModel(18, "Samara", 35, 35.2, true, R.drawable.ic_058_storm, "30.07.2020"));
//        models.add(new WeatherModel(19, "Lomi",50, 10, true, R.drawable.ic_032_wind, "31.07.2020"));
//        models.add(new WeatherModel(20, "Berlin",65, 0.2, true, R.drawable.ic_048_snowing, "01.08.2020"));
//        models.add(new WeatherModel(22, "Kuala",57, 5.2, true, R.drawable.ic_059_hot_weather, "02.08.2020"));
//    }
}