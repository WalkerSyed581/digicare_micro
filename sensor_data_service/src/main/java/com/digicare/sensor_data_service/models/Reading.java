package com.digicare.sensor_data_service.models;
  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
public class Reading {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Long id;

  public double temperature;
  public double heart_rate;
  public double spo2;

  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
  public Date timestamp;
  
  public static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

  public Reading() {}


  public Reading(double temperature, double heart_rate, double spo2,Date timestamp) {
    this.temperature = temperature;
    this.heart_rate = heart_rate;
    this.spo2 = spo2;
    this.timestamp = timestamp;
  }



  @Override
  public String toString() {
    return String.format(
        "Reading[id=%d,Timestamp=%s, Temperature='%f', Heart Rate='%f', Spo2='%f']",
        id,formatter.format(timestamp), temperature, heart_rate,spo2);
  }

  


  public Date getTimestamp() {
    return timestamp;
  }


  public Long getId() {
    return id;
  }

  public double getTemperature() {
    return temperature;
  }


  public double getHeart_rate() {
    return heart_rate;
  }


  public double getSpo2() {
    return spo2;
  }

  

}