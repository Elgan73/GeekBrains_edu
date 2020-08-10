package com.stark.geekbrains_edu.presentation;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

import androidx.appcompat.app.AppCompatActivity;

import com.stark.geekbrains_edu.R;
import com.stark.geekbrains_edu.presentation.city.CityFragment;
import com.stark.geekbrains_edu.service.WeatherService;

public class MainActivity extends AppCompatActivity {

    MainPresenter mainPresenter = new MainPresenter();
    private WeatherService serviceBinder;
    private boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doBindService();
        mainPresenter.onStart(getSupportFragmentManager(), R.id.frgmCont, new CityFragment());
//        Intent intent = new Intent(this, WeatherService.class);
//        bindService(intent, boundServiceConnection, Context.BIND_AUTO_CREATE);
    }

    void doBindService() {
        bindService(new Intent(this, WeatherService.class), boundServiceConnection, Context.BIND_AUTO_CREATE);
        isBound = true;
    }

    void doUnbindService() {
        if (isBound) {
            unbindService(boundServiceConnection);
            isBound = false;
        }
    }

    private ServiceConnection boundServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            serviceBinder = ((WeatherService.ServiceBinder) service).getService();
            isBound = serviceBinder != null;
            assert serviceBinder != null;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
            serviceBinder = null;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        doUnbindService();
    }
}