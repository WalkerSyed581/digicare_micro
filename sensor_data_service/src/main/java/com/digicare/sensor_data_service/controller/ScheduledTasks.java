package com.digicare.sensor_data_service.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.digicare.sensor_data_service.models.Reading;
import com.digicare.sensor_data_service.models.UserReading;
import com.digicare.sensor_data_service.repository.ReadingRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ScheduledTasks {


	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ReadingRepository repository;

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);


	private static final String sendReadingsUrl = "http://database-service/storage/readings";

	@Scheduled(fixedRate = 5000)
	public void sendReadingData() {

		if(repository.count() > 4){
			ArrayList<Reading> userReadings = new ArrayList<Reading>();
			for (Reading reading : repository.findAll()) {
				userReadings.add(reading);
			}
			UserReading data = new UserReading();
			data.setReadings(userReadings);
			
			
			String personResultAsJsonStr = restTemplate.postForObject(sendReadingsUrl, data,String.class);
			System.out.println(personResultAsJsonStr);
		}
	}
}
