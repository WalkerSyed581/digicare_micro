package com.digicare.sensor_data_service.model;


import java.util.List;

public class UserReading {

    private List<Reading> readings;


    public List<Reading> getReadings() {
        return readings;
    }

    public void setReadings(List<Reading> readings) {
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

