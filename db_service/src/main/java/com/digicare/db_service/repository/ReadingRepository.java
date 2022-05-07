package com.digicare.db_service.repository;

import java.util.List;

import com.digicare.db_service.models.Reading;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReadingRepository extends MongoRepository<Reading, Long> {

}