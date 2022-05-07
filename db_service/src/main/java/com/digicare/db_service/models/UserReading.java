package com.digicare.db_service.models;


import java.util.Arrays;
import java.util.List;

public class UserReading {

    private String userId;
    private List<Reading> readings;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Reading> getReadings() {
        return readings;
    }

    public void setReadings(List<Reading> readings) {
        this.readings = readings;
    }

    public void initData(String userId) {
        this.setUserId(userId);
        this.setReadings(Arrays.asList(
                new Reading("100", 3),
                new Reading("200", 4)
        ));
    }
}

