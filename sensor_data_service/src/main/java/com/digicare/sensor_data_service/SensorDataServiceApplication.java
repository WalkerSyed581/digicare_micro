package com.digicare.sensor_data_service;

import com.digicare.sensor_data_service.config.Mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SensorDataServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(SensorDataServiceApplication.class, args);
	}

}
