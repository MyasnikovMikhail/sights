package com.example.sights.model.dto;

import com.example.sights.model.City;


public class CityDto {
    Long id;
    String nameCity;
    int numPopulation;
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

    public int getNumPopulation() {
        return numPopulation;
    }

    public boolean isAvailabilityMetro() {
        return availabilityMetro;
    }

    public String getCountry() {
        return country;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumPopulation(int numPopulation) {
        this.numPopulation = numPopulation;
    }

    public void setAvailabilityMetro(boolean availabilityMetro) {
        this.availabilityMetro = availabilityMetro;
    }

}
