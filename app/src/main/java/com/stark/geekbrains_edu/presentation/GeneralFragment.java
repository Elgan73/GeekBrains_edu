package com.stark.geekbrains_edu.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.stark.geekbrains_edu.R;
import com.stark.geekbrains_edu.presentation.city.CityFragment;
import com.stark.geekbrains_edu.presentation.weather.WeatherFragment;

public class GeneralFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    Button cityChange;
    Button myWeather;

    public GeneralFragment() {
    }

    public static GeneralFragment newInstance(String param1, String param2) {
        GeneralFragment fragment = new GeneralFragment();
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

        View rootView = inflater.inflate(R.layout.fragment_general, container, false);
        cityChange = rootView.findViewById(R.id.changeCity);
        cityChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class classFragment;
                classFragment = CityFragment.class;
                replaceFragment(classFragment);
            }
        });
        myWeather = rootView.findViewById(R.id.myWeather);
        myWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class classFragment;
                classFragment = WeatherFragment.class;
                replaceFragment(classFragment);
            }
        });
        return rootView;
    }

    private void replaceFragment(Class classFragment){
        try {
            Fragment fragment = (Fragment) classFragment.newInstance();
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frgmCont, fragment).addToBackStack("").commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}