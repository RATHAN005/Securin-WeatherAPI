package com.securin.weather_api.util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.securin.weather_api.entity.Weather;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvService {

    public List<Weather> parseWeatherCsv(String filePath) {
        List<Weather> weatherData = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            // Skip header
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                try {
                    Weather weather = Weather.builder()
                            .datetimeUtc(nextLine[0])
                            .conds(nextLine[1])
                            .hum(parseSafeDouble(nextLine[6]))
                            .pressurem(parseSafeDouble(nextLine[8]))
                            .tempm(parseSafeDouble(nextLine[11]))
                            .wspdm(parseSafeDouble(nextLine[19]))
                            .build();
                    weatherData.add(weather);
                } catch (Exception e) {
                    // Skip malformed rows
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return weatherData;
    }

    private Double parseSafeDouble(String val) {
        if (val == null || val.trim().isEmpty())
            return null;
        try {
            return Double.parseDouble(val.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
