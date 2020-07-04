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

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_acitivity);
        final TextView city = findViewById(R.id.city);
        Intent intent = getIntent();
        String selectedCity = intent.getStringExtra("selectedCity");
        city.setText(selectedCity);

        city.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/" + city.getText()));
                    startActivity(intent);
                }
                return false;
            }
        });
    }
}