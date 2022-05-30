package com.example.sights.model.dto;

public class CityDto {

    private Long id;

    private String nameCity;

    private int numPopulation;

    private boolean availabilityMetro;

    private String country;

    public CityDto() {
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

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public void setNumPopulation(int numPopulation) {
        this.numPopulation = numPopulation;
    }

    public void setAvailabilityMetro(boolean availabilityMetro) {
        this.availabilityMetro = availabilityMetro;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
