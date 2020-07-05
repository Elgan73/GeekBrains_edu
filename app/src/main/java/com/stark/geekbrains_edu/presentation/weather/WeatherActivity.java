package com.stark.geekbrains_edu.presentation.weather;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.stark.geekbrains_edu.R;

public class WeatherActivity extends AppCompatActivity {
    //TODO 8.07.2020 сделать выбор Цельсий Фаренгейт, показ скорости ветра и показ влажности
    char celsius = 0x00B0;
    char fahrenheit = 0x2109;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_acitivity);
        final TextView city = findViewById(R.id.city);
        final TextView date = findViewById(R.id.dateTime);
        final TextView temperature = findViewById(R.id.temperature);
        final TextView temp1 = findViewById(R.id.temp1);
        final TextView temp2 = findViewById(R.id.temp2);
        final TextView temp3 = findViewById(R.id.temp3);
        final TextView temp4 = findViewById(R.id.temp4);
        final TextView temp5 = findViewById(R.id.temp5);
        date.setText(WeatherPresenter.getInstance().getDate());
        Intent intent = getIntent();
        String selectedCity = intent.getStringExtra("selectedCity");
        int[] temp = intent.getIntArrayExtra("tempCity");
        city.setText(selectedCity);
        temperature.setText(Integer.toString(temp[0]) + celsius);
        temp1.setText(Integer.toString(temp[1]) + celsius);
        temp2.setText(Integer.toString(temp[2]) + celsius);
        temp3.setText(Integer.toString(temp[3]) + celsius);
        temp4.setText(Integer.toString(temp[4]) + celsius);
        temp5.setText(Integer.toString(temp[5]) + celsius);

        city.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/" + city.getText()));
                    startActivity(intent);
                }
                return false;
            }
        });
    }
}