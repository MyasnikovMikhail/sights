package com.example.sights.model.dto;

public class CityUpdDto {

    int numPopulation;

    boolean availabilityMetro;

    public CityUpdDto() {
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
