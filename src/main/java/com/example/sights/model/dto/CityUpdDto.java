package com.example.sights.model.dto;

import com.example.sights.model.City;

public class CityUpdDto {
    int numPopulation;
    boolean availabilityMetro;

    public CityUpdDto(City city) {
        this.numPopulation = city.getNumPopulation();
        this.availabilityMetro = city.isAvailabilityMetro();
    }

    public int getNumPopulation() {
        return numPopulation;
    }

    public boolean isAvailabilityMetro() {
        return availabilityMetro;
    }

    public void setNumPopulation(int numPopulation) {
        this.numPopulation = numPopulation;
    }

    public void setAvailabilityMetro(boolean availabilityMetro) {
        this.availabilityMetro = availabilityMetro;
    }
}
