package com.securin.weather_api.controller;

import com.securin.weather_api.entity.Weather;
import com.securin.weather_api.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping
    public Page<Weather> getWeather(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "datetimeUtc") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(required = false) Double minTemp,
            @RequestParam(required = false) Double maxTemp) {

        return weatherService.getAllWeather(page, size, sortBy, direction, minTemp, maxTemp);
    }
}
