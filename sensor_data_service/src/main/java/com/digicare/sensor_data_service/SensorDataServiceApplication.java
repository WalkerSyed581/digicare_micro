package com.digicare.sensor_data_service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import com.digicare.sensor_data_service.config.Mqtt;
import com.digicare.sensor_data_service.models.Reading;
import com.digicare.sensor_data_service.repository.ReadingRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class SensorDataServiceApplication {




	public static void main(String[] args) {
		SpringApplication.run(SensorDataServiceApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(SensorDataServiceApplication.class);

	@Bean
  	public CommandLineRunner demo(ReadingRepository repository) {
		return (args) -> {
			// save a few readingss
			Date date = new Date(); // This object contains the current date value
			repository.save(new Reading(98.0,89,99.0,date));
			repository.save(new Reading(97.2,77,99.2,date));
			repository.save(new Reading(98.1,82,99.5,date));
			repository.save(new Reading(97.5,85,98.9,date));
			repository.save(new Reading(96.5,88,99.1,date));




			// fetch all readings
			log.info("Readings found with findAll():");
			log.info("-------------------------------");
			for (Reading Reading : repository.findAll()) {
				log.info(Reading.toString());
			}
			log.info("");

			// fetch an individual Reading by ID
			Reading reading = repository.findById(1L);
			log.info("Reading found with findById(1L):");
			log.info("--------------------------------");
			log.info(reading.toString());
			log.info("");

			
			log.info("");	
			Mqtt subscriber = new Mqtt();
			subscriber.subscribe("reading");

		};
  	}


	@Bean
	public Mqtt getMqtt() {
		return new Mqtt();   
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
