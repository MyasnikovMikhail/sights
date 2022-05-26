package com.example.sights.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column (name="name_City")
    private String nameCity;

    @Column (name="num_population")
    private Long numPopulation;

    @Column (name="availability_metro")
    private boolean availabilityMetro;

    @Column (name="country")
    private String country;

   @OneToMany(fetch = FetchType.EAGER, mappedBy = "city")
    private Set<Sight> sightsCity;


    public City() {
    }

    public City(String nameCity, Long numPopulation, boolean availabilityMetro, String country) {
        this.nameCity = nameCity;
        this.numPopulation = numPopulation;
        this.availabilityMetro = availabilityMetro;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public Long getNumPopulation() {
        return numPopulation;
    }

    public void setNumPopulation(Long numPopulation) {
        this.numPopulation = numPopulation;
    }

    public boolean isAvailabilityMetro() {
        return availabilityMetro;
    }

    public void setAvailabilityMetro(boolean availabilityMetro) {
        this.availabilityMetro = availabilityMetro;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Sight> getSightsCity() {
        return sightsCity;
    }

    public void setSightsCity(Set<Sight> sightsCity) {
        this.sightsCity = sightsCity;
    }
}
