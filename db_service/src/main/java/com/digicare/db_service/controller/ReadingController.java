package com.digicare.db_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.digicare.db_service.models.Reading;
import com.digicare.db_service.models.UserReading;
import com.digicare.db_service.repository.ReadingRepository;

@RestController
@RequestMapping("/storage")
public class ReadingController{
	
//	@Autowired
//	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ReadingRepository repository;
	

	// Get reeadings from the other microservice and add it to the database
	@PostMapping("/readings")
	public void storeReadings(@RequestBody UserReading userReadings){
		List<Reading> my_readings = userReadings.getReadings();
		my_readings.forEach((reading) -> {
			repository.save(reading);
		});
	}
}