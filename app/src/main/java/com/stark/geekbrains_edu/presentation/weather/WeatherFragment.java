package com.stark.geekbrains_edu.presentation.weather;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;
import com.stark.geekbrains_edu.Model.Weather;
import com.stark.geekbrains_edu.R;
import com.stark.geekbrains_edu.presentation.city.CityFragment;
import com.stark.geekbrains_edu.presentation.settings.SettingsFragment;
import com.stark.geekbrains_edu.repo.Repository;

import java.io.BufferedReader;

public class WeatherFragment extends Fragment{

    private TextView cityPretty;
    private TextView datePretty;
    private TextView tempPretty;
    private TextView perceivedPretty;
    private ImageView imagePretty;
    private TextView humidity;
    private TextView windSpeed;
    private TextView weatherDesc;
    private ImageView settings;
    private MapView mMapView;
    private GoogleMap googleMap;
    private final Handler handler = new Handler();
    private char tmp = 0x00B0;
    private char percent = 0x25;
    Repository repository = new Repository();
    WeatherPresenter weatherPresenter = new WeatherPresenter();

    public WeatherFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.pretty_weather, container, false);
        init(rootView);
        mMapView = rootView.findViewById(R.id.mapGoogle);
        mMapView.onCreate(savedInstanceState);


        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());

        } catch (Exception e) {
            e.printStackTrace();
        }


        new Thread(() -> {
            String city = getArguments().getString("CITY");
            BufferedReader in = repository.getJson(city);
            Gson gson = new GsonBuilder().create();
            final Weather weather = gson.fromJson(in, Weather.class);
            handler.post(() -> displayWeather(weather, rootView));
            mMapView(handler, weather);
        }).start();
        return rootView;
    }

    private void mMapView(Handler handler, Weather weather) {
        handler.post(() -> mMapView.getMapAsync(mMap -> {
            googleMap = mMap;

            LatLng target = new LatLng(doubleLatLng(weather.location.lat), doubleLatLng(weather.location.lon));
            googleMap.addMarker(new MarkerOptions().position(target).title(weather.location.name));

            CameraPosition cameraPosition = new CameraPosition.Builder().target(target).zoom(7).build();
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        }));
    }

    private void init(View view) {
        datePretty = view.findViewById(R.id.datePretty);
        cityPretty = view.findViewById(R.id.cityPretty);
        tempPretty = view.findViewById(R.id.tempPretty);
        perceivedPretty = view.findViewById(R.id.perceivedPretty);
        imagePretty = view.findViewById(R.id.imagePretty);
        humidity = view.findViewById(R.id.humidityPretty);
        windSpeed = view.findViewById(R.id.windSpeedPretty);
        cityPretty.setOnClickListener(clickListener);
        weatherDesc = view.findViewById(R.id.weatherDescription);
        settings = view.findViewById(R.id.settingsPretty);
        settings.setOnClickListener(clickListenerSettings);
    }

    View.OnClickListener clickListenerSettings = view -> {
        weatherPresenter.navigate(getFragmentManager(), R.id.frgmCont, new SettingsFragment(), null);
    };

    View.OnClickListener clickListener = view ->
            weatherPresenter.navigate(getFragmentManager(), R.id.frgmCont, new CityFragment(), null);

    private void displayWeather(Weather weather, View view) {
        if (weather.error != null) {
            Snackbar snackbar = Snackbar.make(view, "Request failed, please try again", Snackbar.LENGTH_LONG);
            snackbar.getView();
            snackbar.show();
        } else {
            cityPretty.setText(weather.location.name);
            datePretty.setText(weatherPresenter.date());
            tempPretty.setText(weather.current.temperature.toString() + tmp);
            perceivedPretty.setText(weather.current.feelslike.toString() + tmp);
            String url = weather.current.weatherIcons.get(0);
            Picasso.get().load(url).into(imagePretty);
            humidity.setText(weather.current.humidity.toString() + percent);
            windSpeed.setText(weather.current.windSpeed + "m/s");
            weatherDesc.setText(weather.current.weatherDescriptions.get(0));

        }

    }

    private double doubleLatLng(String a) {
        return Double.parseDouble(a);
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}