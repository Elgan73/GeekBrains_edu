package com.stark.geekbrains_edu.data.db.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index(value = {"date", "city", "wind", "humidity", "temp"})})
public class EntityCity {
    @PrimaryKey(autoGenerate = true)
    public int weatherId;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "city")
    public String city;

    @ColumnInfo(name = "wind")
    public String wind;

    @ColumnInfo(name = "humidity")
    public String humidity;

    @ColumnInfo(name = "temp")
    public String temp;
}
