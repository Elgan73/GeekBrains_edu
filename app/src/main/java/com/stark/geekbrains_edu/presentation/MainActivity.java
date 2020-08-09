package com.stark.geekbrains_edu.presentation;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

import androidx.appcompat.app.AppCompatActivity;

import com.stark.geekbrains_edu.R;
import com.stark.geekbrains_edu.presentation.weather.WeatherFragment;
import com.stark.geekbrains_edu.service.WeatherService;

public class MainActivity extends AppCompatActivity {

    MainPresenter mainPresenter = new MainPresenter();
    private WeatherService.ServiceBinder serviceBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter.onStart(getSupportFragmentManager(), R.id.frgmCont, new WeatherFragment());
        savedInstanceState.putString("CITY", "Ulyanovsk");
        Intent intent = new Intent(this, WeatherService.class);
        bindService(intent, boundServiceConnection, Context.BIND_AUTO_CREATE);

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            serviceBinder.getWeatherData("Ulyanovsk");
        }).start();
    }

    private ServiceConnection boundServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            serviceBinder = (WeatherService.ServiceBinder) binder;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            stopService(getIntent());
        }
    };



}