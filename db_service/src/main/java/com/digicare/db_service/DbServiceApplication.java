package com.digicare.db_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class DbServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(DbServiceApplication.class, args);
	}
	
 
	@Bean
	@LoadBalanced	
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
