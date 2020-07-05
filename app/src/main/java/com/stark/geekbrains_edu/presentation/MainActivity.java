package com.stark.geekbrains_edu.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.stark.geekbrains_edu.R;
import com.stark.geekbrains_edu.presentation.city.CityChangeActivity;
import com.stark.geekbrains_edu.presentation.settings.SettingsActivity;
import com.stark.geekbrains_edu.presentation.weather.WeatherActivity;

public class MainActivity extends AppCompatActivity {

    Button cityChange;
    Button myWeather;
    Button settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_LONG).show();
        Log.d("onCreate", "Activity -> onCreate");

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
                startActivity(intent);
            }
        });
        settings = findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }



    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_LONG).show();
        Log.d("onRestart", "Activity -> onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_LONG).show();
        Log.d("OnStart", "Activity -> onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show();
        Log.d("onResume", "Activity -> onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_LONG).show();
        Log.d("onPause", "Activity -> onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_LONG).show();
        Log.d("onStop", "Activity -> onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy if possible =)", Toast.LENGTH_LONG).show();
        Log.d("onDestroy", "Activity -> onDestroy");
    }

}