package com.stark.geekbrains_edu.presentation.city;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.stark.geekbrains_edu.R;
import com.stark.geekbrains_edu.presentation.weather.WeatherFragment;

public class CityFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    Button sendData;
    String[] dataSpinner = {"", "Ulyanovsk", "Moscow", "Vladivostok", "Voronezh"};
    CityPresenter cityPresenter = new CityPresenter();
    TextInputEditText typeCity;

    public CityFragment() {
    }

//    public static CityFragment newInstance(String param1, String param2) {
//        CityFragment fragment = new CityFragment();
//
//
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_city, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, dataSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner spinner = rootView.findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        typeCity = rootView.findViewById(R.id.typeCity);
        sendData = rootView.findViewById(R.id.sendData);
        sendData.setOnClickListener(view -> {
            if (typeCity.getText().toString().equals("")) {
                String c = spinner.getSelectedItem().toString();
                if (!spinner.getSelectedItem().toString().equals("")) {
                    cityPresenter.navigate(getFragmentManager(), R.id.frgmCont, new WeatherFragment(), spinner.getSelectedItem().toString());
                } else {
                    Snackbar snackbar = Snackbar.make(rootView, "Choose your city, dude!", Snackbar.LENGTH_LONG);
                    snackbar.getView();
                    snackbar.show();
                }
            } else {
                if(typeCity.getText() != null) {
                    cityPresenter.navigate(getFragmentManager(), R.id.frgmCont, new WeatherFragment(), typeCity.getText().toString());
                } else {
                    Snackbar snackbar = Snackbar.make(rootView, "Choose your city, dude!", Snackbar.LENGTH_LONG);
                    snackbar.getView();
                    snackbar.show();
                }
            }
        });
        return rootView;
    }

    private void saveToSharedPreference(SharedPreferences sharedPref, String city) {
        SharedPreferences.Editor editor = sharedPref.edit();
        String MY_CITY = "";
        editor.putString(MY_CITY, city);
        editor.apply();

    }
}