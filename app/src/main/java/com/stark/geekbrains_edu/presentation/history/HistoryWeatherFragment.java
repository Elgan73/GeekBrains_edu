package com.stark.geekbrains_edu.presentation.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.stark.geekbrains_edu.App;
import com.stark.geekbrains_edu.R;
import com.stark.geekbrains_edu.data.db.CitySource;
import com.stark.geekbrains_edu.data.db.dao.WeatherDao;

public class HistoryWeatherFragment extends Fragment {

    private RVAdapter rvAdapter;
    private CitySource citySource;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        initHistoryList(view);
        return view;
    }


    private void initHistoryList(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.requireContext());
        recyclerView.setLayoutManager(layoutManager);

        WeatherDao weatherDao = App.getInstance().getCityDao();
        citySource = new CitySource(weatherDao);

        rvAdapter = new RVAdapter(citySource);
        recyclerView.setAdapter(rvAdapter);

    }



}
