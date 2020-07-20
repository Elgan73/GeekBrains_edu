//package com.stark.geekbrains_edu.presentation.weather;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.stark.geekbrains_edu.Model.Weather;
//import com.stark.geekbrains_edu.R;
//
//import java.util.Collection;
//import java.util.List;
//
//public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
//
//    private LayoutInflater inflater;
//    private List<Weather> weatherList;
//
//    public void setItems(Collection<Weather> model) {
//        weatherList.addAll(model);
//        notifyDataSetChanged();
//    }
//
//    public void clearItems() {
//        weatherList.clear();
//        notifyDataSetChanged();
//    }
//
//    public WeatherAdapter(Context context, List<Weather> weatherList) {
//        this.inflater = LayoutInflater.from(context);
//        this.weatherList = weatherList;
//    }
//
//    @NonNull
//    @Override
//    public WeatherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = inflater.inflate(R.layout.weather_item, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public int getItemCount() {return weatherList.size();}
//
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.bind(weatherList.get(position));
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        private ImageView imageView;
//        private TextView date, humidity, temp, windSpeed;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            imageView = itemView.findViewById(R.id.imageViewItem);
//            date = itemView.findViewById(R.id.dateItem);
//            humidity = itemView.findViewById(R.id.humidityItem);
//            temp = itemView.findViewById(R.id.tempItem);
//            windSpeed = itemView.findViewById(R.id.windItem);
//        }
//
//        public void bind(Weather wm) {
////            Picasso.get().load(wm.current.weatherIcons).into(imageView);
////            date.setText(wm.getDate());
////            humidity.setText(wm.getHumidity());
////            temp.setText(wm.getTemperature());
////            windSpeed.setText((int)wm.getWindSpeed());
//
//        }
//    }
//
//}
//
//
////Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageView);