package com.securin.weather_api.config;

import com.securin.weather_api.entity.Weather;
import com.securin.weather_api.repository.WeatherRepository;
import com.securin.weather_api.util.CsvService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final WeatherRepository weatherRepository;
    private final CsvService csvService;

    @Override
    public void run(String... args) throws Exception {
        if (weatherRepository.count() == 0) {
            String filePath = "D:\\Securin weather app\\weather-data\\Assessment 2\\testset.csv";
            log.info("Starting CSV data import from: {}", filePath);
            List<Weather> data = csvService.parseWeatherCsv(filePath);
            int batchSize = 1000;
            for (int i = 0; i < data.size(); i += batchSize) {
                int end = Math.min(i + batchSize, data.size());
                weatherRepository.saveAll(data.subList(i, end));
                log.info("Imported {}/{} records...", end, data.size());
            }
            log.info("Import completed successfully!");
        } else {
            log.info("Database already contains data, skipping import.");
        }
    }
}