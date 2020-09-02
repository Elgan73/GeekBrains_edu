package com.stark.geekbrains_edu.presentation.city;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.stark.geekbrains_edu.R;
import com.stark.geekbrains_edu.presentation.weather.WeatherFragment;

public class CityFragment extends Fragment {

    Button sendData;
    CityPresenter cityPresenter = new CityPresenter();
    TextInputEditText typeCity;
    SharedPreferences sharedPref;

    public CityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_city, container, false);
        typeCity = rootView.findViewById(R.id.typeCity);
        sendData = rootView.findViewById(R.id.sendData);
        sendData.setOnClickListener(view -> {
                if(typeCity.getText() != null) {
                    cityPresenter.navigate(getFragmentManager(), R.id.frgmCont, new WeatherFragment(), typeCity.getText().toString());
                    saveToSharedPreference(sharedPref, typeCity.getText().toString());
                } else {
                    Snackbar snackbar = Snackbar.make(rootView, "Choose your city, dude!", Snackbar.LENGTH_LONG);
                    snackbar.getView();
                    snackbar.show();
                }
        });
        return rootView;
    }

    private void saveToSharedPreference(SharedPreferences sharedPref, String city) {
        sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("MY_CITY", city);
        editor.apply();

    }
}