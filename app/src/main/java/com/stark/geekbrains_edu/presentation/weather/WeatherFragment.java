package com.stark.geekbrains_edu.presentation.weather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.stark.geekbrains_edu.Model.WeatherModel;
import com.stark.geekbrains_edu.R;

import java.util.List;

public class WeatherFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private List<WeatherModel> models;
    public WeatherModel weatherModel = new WeatherModel();
    private TextView city;

    public WeatherFragment() {
    }

    public static WeatherFragment newInstance(String param1, String param2) {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_weather, container, false);
        city = rootView.findViewById(R.id.city);
        city.setText(weatherModel.getCity());
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerViewWeather);
        WeatherAdapter weatherAdapter = new WeatherAdapter(getContext(), models);
        recyclerView.setAdapter(weatherAdapter);


        return rootView;
    }
}