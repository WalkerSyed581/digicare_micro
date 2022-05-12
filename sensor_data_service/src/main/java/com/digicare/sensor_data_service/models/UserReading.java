package com.digicare.sensor_data_service.models;


import java.util.ArrayList;

public class UserReading {

    private ArrayList<Reading> readings;


    public ArrayList<Reading> getReadings() {
        return readings;
    }

    public void setReadings(ArrayList<Reading> readings) {
        this.readings = readings;
    }

    // public void initData(String userId) {
    //     this.setUserId(userId);
    //     this.setReadings(Arrays.asList(
    //             new Reading("100", 3),
    //             new Reading("200", 4)
    //     ));
    // }
}

