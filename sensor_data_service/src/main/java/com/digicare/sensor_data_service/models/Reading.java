package com.digicare.sensor_data_service.model;
  
import org.springframework.data.annotation.Id;


public class Reading {
  
  @Id
  public Long id;

  public float temperature;
  public float heart_rate;
  public float spo2;

  public Reading() {}

  @Override
  public String toString() {
    return String.format(
        "Reading[id=%l, Temperature='%f', Heart Rate='%f', Spo2='%f']",
        id, temperature, heart_rate,spo2);
  }

}