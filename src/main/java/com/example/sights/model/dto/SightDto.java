package com.example.sights.model.dto;

import com.example.sights.model.City;
import com.example.sights.model.Sight;
import com.example.sights.model.TypeSight;

import java.util.Date;


public class SightDto {
    private Long id;
    private String nameSight;
    private Date date;
    private String description;
    private TypeSight type;
    private City city;

    public SightDto(Sight sight) {
        this.id = sight.getId();
        this.nameSight = sight.getNameSight();
        this.date = sight.getDate();
        this.description = sight.getDescription();
        this.type = sight.getType();
        this.city = sight.getCity();
    }

    public Long getId() {
        return id;
    }

    public String getNameSight() {
        return nameSight;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public TypeSight getType() {
        return type;
    }

    public City getCity() {
        return city;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
