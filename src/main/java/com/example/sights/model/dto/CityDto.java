package com.example.sights.model.dto;

import com.example.sights.model.City;
import com.example.sights.model.Sight;
import lombok.Data;

@Data
public class CityDto {
    Long id;
    String nameCity;
    Long numPopulation;
    boolean availabilityMetro;
    String country;

    public CityDto(City city) {
        this.id = city.getId();
        this.nameCity = city.getNameCity();
        this.numPopulation = city.getNumPopulation();
        this.availabilityMetro = isAvailabilityMetro();
        this.country = city.getCountry();
    }

    public Long getId() {
        return id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public Long getNumPopulation() {
        return numPopulation;
    }

    public boolean isAvailabilityMetro() {
        return availabilityMetro;
    }

    public String getCountry() {
        return country;
    }
}
