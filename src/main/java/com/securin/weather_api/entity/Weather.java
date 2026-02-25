package com.securin.weather_api.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Document(collection = "weather")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Weather {

    @Id
    private String id;

    private String datetimeUtc;

    private String conds;

    private Double tempm;

    private Double hum;

    private Double pressurem;

    private Double wspdm;
}