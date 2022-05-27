package com.example.sights.model.dto;

import lombok.Data;

@Data
public class CityDto {
    Long id;
    String nameCity;
    Long numPopulation;
    boolean availabilityMetro;
    String country;
}
