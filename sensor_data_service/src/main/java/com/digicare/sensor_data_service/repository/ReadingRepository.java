package com.digicare.sensor_data_service.repository;


import java.util.List;

import com.digicare.sensor_data_service.models.Reading;

import org.springframework.data.repository.CrudRepository;

public interface ReadingRepository extends CrudRepository<Reading, Long> {


  Reading findById(long id);
}