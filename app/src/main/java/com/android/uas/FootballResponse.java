package com.android.uas;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FootballResponse {
    @SerializedName("events")
    private ArrayList<Football> events;

    public ArrayList<Football> getEvents() {
        return events;
    }

    public void setResults(ArrayList<Football> results) {
        this.events = events;
    }

}
