package com.digicare.db_service.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.digicare.db_service.models.Reading;
import com.digicare.db_service.models.UserReading;

@RestController
@RequestMapping("/storage")
public class ReadingController{
	
//	@Autowired
//	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	

	//TODO
	// Get reeadings from the other microservice and add it to the database
	@PostMapping("/readings")
	public void storeReadings(@RequestBody UserReading userReadings){
		
	}
}