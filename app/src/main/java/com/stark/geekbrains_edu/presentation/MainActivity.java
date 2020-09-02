package com.stark.geekbrains_edu.presentation;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.stark.geekbrains_edu.R;
import com.stark.geekbrains_edu.Reciever.ConnectedReceiver;
import com.stark.geekbrains_edu.Reciever.PowerConnection;
import com.stark.geekbrains_edu.presentation.StartScreen.StartScreenFragment;

public class MainActivity extends AppCompatActivity {

    MainPresenter mainPresenter = new MainPresenter();

    private ConnectedReceiver wiFiStateChange = new ConnectedReceiver();
    private PowerConnection powerConnected = new PowerConnection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter.onStart(getSupportFragmentManager(), R.id.frgmCont, new StartScreenFragment());
        registerBroadcastReceivers();
        initNotificationChannel();
    }

    private void initNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            int importance = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel channel = new NotificationChannel("2", "name", importance);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void registerBroadcastReceivers() {
        registerReceiver(wiFiStateChange, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        registerReceiver(powerConnected, new IntentFilter(Intent.ACTION_POWER_CONNECTED));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(wiFiStateChange);
        unregisterReceiver(powerConnected);
    }


}