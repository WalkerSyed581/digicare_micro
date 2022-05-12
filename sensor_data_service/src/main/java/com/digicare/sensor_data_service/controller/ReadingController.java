package com.digicare.sensor_data_service.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.digicare.sensor_data_service.config.Mqtt;
import com.digicare.sensor_data_service.models.*;

@RestController
@RequestMapping("/sensor")
public class ReadingController{
	
//	@Autowired
//	private WebClient.Builder webClientBuilder;
	
	// @Autowired
	// private RestTemplate restTemplate;
	
	// @Autowired
    // Mqtt my_mqtt;

	// //TODO
	// @RequestMapping("/trigger")
	// public void triggerSensor(){
	// 	MqttPublishModel publishMessage;
	// 	my_mqtt.subscribe("/reading");
		
	// }
	
	// //TODO
	// @RequestMapping("/stop")
	// public void stopSensor(){

	// 	MqttClient sub_client = my_mqtt.getSub_client();
	// 	try {
	// 		sub_client.unsubscribe("/reading");
	// 	} catch (MqttException e) {
	// 		// TODO Auto-generated catch block
	// 		e.printStackTrace();
	// 	}
		

	// }

	// @RequestMapping("/{userId}")
	// public List<Reading> getReadings(){
	// 	UserReading readings = restTemplate.getForObject("http://sensor-data-service/readings",UserReading.class);
		
	// 	return readings.getReadings();
		
	// }
}
