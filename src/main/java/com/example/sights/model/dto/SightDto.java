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

    public SightDto(Long id, String nameSight, Date date, String description, TypeSight type, City city) {
        this.id = Sight.getId();
        this.nameSight = Sight.getNameSight();
        this.date = Sight.getDate();
        this.description = Sight.getDescription();
        this.type = Sight.getType();
        this.city = Sight.getCity();
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

}
