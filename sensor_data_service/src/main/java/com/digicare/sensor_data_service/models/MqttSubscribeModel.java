package com.digicare.sensor_data_service.model;

// import java.util.Date;

// public class MqttSubscribeModel {

//     private Date timestamp;
//     private float Spo2;
//     private float heartRate;
//     private float tempC;
//     private Integer classification;

//     public Date getTimestamp() {
//         return timestamp;
//     }
//     public void setTimestamp(Date timestamp) {
//         this.timestamp = timestamp;
//     }
//     public float getSpo2() {
//         return Spo2;
//     }
//     public void setSpo2(float spo2) {
//         Spo2 = spo2;
//     }
//     public float getHeartRate() {
//         return heartRate;
//     }
//     public void setHeartRate(float heartRate) {
//         this.heartRate = heartRate;
//     }
//     public float getTempC() {
//         return tempC;
//     }
//     public void setTempC(float tempC) {
//         this.tempC = tempC;
//     }
//     public Integer getClassification() {
//         return classification;
//     }
//     public void setClassification(Integer classification) {
//         this.classification = classification;
//     }

// }

public class MqttSubscribeModel {

    private String message;
    private Integer qos;
    private Integer id;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getQos() {
        return qos;
    }

    public void setQos(Integer qos) {
        this.qos = qos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}