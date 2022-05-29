package com.example.sights.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="cities")
public class City {
    @Id
    @Column(name="id")
    @SequenceGenerator(name="clientsIdSeq", sequenceName="clients_id_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="clientsIdSeq")
    private Long id;

    @Column(name="name_city")
    private String nameCity;

    @Column (name="num_population")
    private Integer numPopulation;

    @Column (name="availability_metro")
    private Boolean availabilityMetro;

    @Column (name="country")
    private String country;

   @OneToMany(fetch = FetchType.LAZY,mappedBy="city")
   //@JsonManagedReference
    private Set<Sight> sightsCity;

   public City() {
    }

    public City(String nameCity, int numPopulation, boolean availabilityMetro, String country) {
        this.nameCity = nameCity;
        this.numPopulation = numPopulation;
        this.availabilityMetro = availabilityMetro;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public int getNumPopulation() {
        return numPopulation;
    }

    public void setNumPopulation(int numPopulation) {
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
