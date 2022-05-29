package com.example.sights.model.dto;

import com.example.sights.model.TypeSight;

import java.util.Date;


public class SightDto {
    private Long id;
    private String nameSight;
    private Date date;
    private String description;
    private TypeSight type;
    private Long cityId;

    public SightDto() {
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

    public Long getCityId() {
        return cityId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNameSight(String nameSight) {
        this.nameSight = nameSight;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setType(TypeSight type) {
        this.type = type;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
