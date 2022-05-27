package com.digicare.db_service.models;
  
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.data.annotation.Id;

public class Reading {

  @Id
  public String id;

  public double temperature;
  public double heart_rate;
  public double spo2;
  
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
  public LocalDateTime timestamp;

  public boolean sent;

  public static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

  

  public boolean getSent() {
    return sent;
  }

  public void setSent(boolean sent) {
    this.sent = sent;
  }

  public Reading() {}

  public Reading(double temperature, double heart_rate, double spo2,LocalDateTime timestamp) {
    this.temperature = temperature;
    this.heart_rate = heart_rate;
    this.spo2 = spo2;
    this.timestamp = timestamp;
  }



  @Override
  public String toString() {
    return String.format(
        "Reading[id=%d,Timestamp=%s, Temperature='%f', Heart Rate='%f', Spo2='%f']",
        id,timestamp.toString(), temperature, heart_rate,spo2);
  }

  


  public LocalDateTime getTimestamp() {
    return timestamp;
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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