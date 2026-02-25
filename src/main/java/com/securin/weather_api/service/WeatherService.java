package com.securin.weather_api.service;

import com.securin.weather_api.entity.Weather;
import com.securin.weather_api.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public Page<Weather> getAllWeather(int page, int size, String sortBy, String direction, Double minTemp,
            Double maxTemp) {
        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);

        if (minTemp != null && maxTemp != null) {
            return weatherRepository.findByTempmBetween(minTemp, maxTemp, pageable);
        }
        return weatherRepository.findAll(pageable);
    }
}