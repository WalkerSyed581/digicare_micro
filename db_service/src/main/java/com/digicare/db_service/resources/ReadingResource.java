package com.digicare.db_service.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.digicare.db_service.models.Reading;

@RestController
@RequestMapping("/catalog")
public class ReadingResource{
	
//	@Autowired
//	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	public List<Reading> getReadings(){
		Reading ratings = restTemplate.getForObject("http://sensor-data-service/readings",UserRating.class);
		return ratings.stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+ rating.getMovieId(), Movie.class);
			

			
			
			return new CatalogItem(movie.getName(),"Desc",rating.getRating());
		})
				.collect(Collectors.toList());
		
//		return Collections.singletonList(
//				new CatalogItem("Transformers","Test",4));
		
	}
}

//			Movie movie = webClientBuilder.build()
//			.get()
//			.uri("http://localhost:8081/movies/"+ rating.getMovieId())
//			.retrieve()
//			.bodyToMono(Movie.class)
//			.block();