package com.stark.geekbrains_edu.presentation.weather;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
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
import com.squareup.picasso.Picasso;
import com.stark.geekbrains_edu.Model.Weather;
import com.stark.geekbrains_edu.R;
import com.stark.geekbrains_edu.data.net.ApiService;
import com.stark.geekbrains_edu.data.net.RetrofitNetwork;
import com.stark.geekbrains_edu.presentation.city.CityFragment;
import com.stark.geekbrains_edu.presentation.settings.SettingsFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherFragment extends Fragment {

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
    private char tmp = 0x00B0;
    private char percent = 0x25;
    final String API_KEY = "00138a6a0ccff95b3b1e1064f3f9b25c";
    private final Handler handler = new Handler();
    private RetrofitNetwork retrofit = new RetrofitNetwork();
    private ApiService apiService;
    public static final String MY_CITY = "";
    private SharedPreferences mCity;
    WeatherPresenter weatherPresenter = new WeatherPresenter();

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
//        String city = getArguments().getString("CITY");
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        apiService = retrofit.retrofit().create(ApiService.class);
        if(mCity.contains(MY_CITY)) {
            retrofitRequest(mCity.getString(MY_CITY, ""), API_KEY, rootView);
        } else {
            retrofitRequest("Ulyanovsk", API_KEY, rootView);
        }


        return rootView;
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

    private void retrofitRequest(String city, String apiKey, View view) {
        apiService.loadData(apiKey, city).enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if(response.body() != null) {
                    cityPretty.setText(response.body().location.name);
                    String strCity = response.body().location.name;
                    saveToSharedPreference(mCity, strCity);
                    datePretty.setText(weatherPresenter.date());
                    tempPretty.setText(response.body().current.temperature.toString() + tmp);
                    perceivedPretty.setText(response.body().current.feelslike.toString() + tmp);
                    String url = response.body().current.weatherIcons.get(0);
                    Picasso.get().load(url).into(imagePretty);
                    humidity.setText(response.body().current.humidity.toString() + percent);
                    windSpeed.setText(response.body().current.windSpeed + "m/s");
                    weatherDesc.setText(response.body().current.weatherDescriptions.get(0));
                    handler.post(() -> mMapView.getMapAsync(mMap -> {
                        googleMap = mMap;

                        LatLng target = new LatLng(doubleLatLng(response.body().location.lat), doubleLatLng(response.body().location.lon));
                        googleMap.addMarker(new MarkerOptions().position(target).title(response.body().location.name));

                        CameraPosition cameraPosition = new CameraPosition.Builder().target(target).zoom(7).build();
                        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                    }));
                }
            }
            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Snackbar snackbar = Snackbar.make(view, "Request failed, please try again", Snackbar.LENGTH_LONG);
                snackbar.getView();
                snackbar.show();
                cityPretty.setText("Error");
                Log.d("ERROR_RETROFIT", t.getLocalizedMessage());
            }
        });
    }

    private double doubleLatLng(String a) {
        return Double.parseDouble(a);
    }

    @Override
    public void onStop() {
        super.onStop();

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


    private void saveToSharedPreference(SharedPreferences sharedPref, String city) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(MY_CITY, city);
        editor.apply();

    }
}