package com.stark.geekbrains_edu.presentation.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stark.geekbrains_edu.R;
import com.stark.geekbrains_edu.data.db.CitySource;
import com.stark.geekbrains_edu.data.db.Entity.EntityCity;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    private CitySource citySource;

    public RVAdapter(CitySource citySource) {
        this.citySource = citySource;
    }

    @NonNull
    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter.ViewHolder holder, int position) {
        List<EntityCity> listOfCities = citySource.getCities();
        final EntityCity city = listOfCities.get(position);
        holder.history_dateItem.setText(city.date);
        holder.history_cityName.setText(city.city);
        holder.history_windItem.setText(city.wind);
        holder.history_humidityItem.setText(city.humidity);
        holder.history_tempItem.setText(city.temp);

    }

    @Override
    public int getItemCount() {
        return (int) citySource.getCountCities();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View history_cardView;
        TextView history_dateItem;
        TextView history_cityName;
        TextView history_windItem;
        TextView history_humidityItem;
        TextView history_tempItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            history_cardView = itemView;
            history_dateItem = history_cardView.findViewById(R.id.history_dateItem);
            history_cityName = history_cardView.findViewById(R.id.history_cityName);
            history_windItem = history_cardView.findViewById(R.id.history_windItem);
            history_humidityItem = history_cardView.findViewById(R.id.history_humidityItem);
            history_tempItem = history_cardView.findViewById(R.id.history_tempItem);
        }
    }
}
