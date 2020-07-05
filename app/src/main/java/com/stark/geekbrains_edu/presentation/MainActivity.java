package com.stark.geekbrains_edu.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.stark.geekbrains_edu.R;
import com.stark.geekbrains_edu.presentation.city.CityChangeActivity;
import com.stark.geekbrains_edu.presentation.weather.WeatherActivity;

public class MainActivity extends AppCompatActivity {

    Button cityChange;
    Button myWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityChange = findViewById(R.id.changeCity);
        cityChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CityChangeActivity.class);
                startActivity(intent);
            }
        });
        myWeather = findViewById(R.id.myWeather);
        myWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                if(intent.getExtras() == null) {
                    Toast.makeText(MainActivity.this, "Choose your city, dude", Toast.LENGTH_LONG).show();
                } else {
                    startActivity(intent);
                }

            }
        });

    }

}