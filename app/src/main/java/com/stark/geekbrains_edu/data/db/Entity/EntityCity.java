package com.stark.geekbrains_edu.data.db.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index(value = {"date", "city", "temp"})})
public class EntityCity {
    @PrimaryKey(autoGenerate = true)
    public int weatherId;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "city")
    public String city;

    @ColumnInfo(name = "temp")
    public double temp;
}
