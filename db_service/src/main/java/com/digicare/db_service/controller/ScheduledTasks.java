package com.digicare.db_service.controller;


import java.util.ArrayList;

import com.digicare.db_service.models.*;
import com.digicare.db_service.repository.ReadingRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Scheduled(fixedRate = 30000)
	public void deleteReadingData() {
		if(repository.count() > 500){
			repository.deleteAll();
		}
	}
}
