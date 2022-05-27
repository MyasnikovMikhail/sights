package com.example.sights.model.dto;

import com.example.sights.model.City;

public class CityUpdDto {
    Long numPopulation;
    boolean availabilityMetro;

    public CityUpdDto(City city) {
        this.availabilityMetro = city.isAvailabilityMetro();
        this.numPopulation = city.getNumPopulation();
    }

    public Long getNumPopulation() {
        return numPopulation;
    }

    public boolean isAvailabilityMetro() {
        return availabilityMetro;
    }

    public void setNumPopulation(Long numPopulation) {
        this.numPopulation = numPopulation;
    }

    public void setAvailabilityMetro(boolean availabilityMetro) {
        this.availabilityMetro = availabilityMetro;
    }
}
