package com.securin.weather_api.repository;

import com.securin.weather_api.entity.Weather;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface WeatherRepository extends MongoRepository<Weather, String> {
        Page<Weather> findByTempmBetween(Double min, Double max, Pageable pageable);
}
