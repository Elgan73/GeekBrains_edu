package com.stark.geekbrains_edu.presentation.city;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.stark.geekbrains_edu.R;
import com.stark.geekbrains_edu.presentation.weather.WeatherActivity;

public class CityChangeActivity extends AppCompatActivity {

    Button sendData;
    String[] dataSpinner = {"", "Ulyanovsk", "Moscow", "Vladivostok", "Voronezh"};
    String city = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_change);
        final Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        final EditText typeCity = findViewById(R.id.typeCity);
        sendData = findViewById(R.id.sendData);
        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CityChangeActivity.this, WeatherActivity.class);
                if (typeCity.getText().toString().equals("")) {
                    String c = spinner.getSelectedItem().toString();
                    CityChangePresenter.getInstance().setCity(c);
                    intent.putExtra("selectedCity", c);
                } else {
                    CityChangePresenter.getInstance().setCity(typeCity.getText().toString());
                    intent.putExtra("selectedCity", typeCity.getText().toString());

                }
                startActivity(intent);
            }
        });
    }
}