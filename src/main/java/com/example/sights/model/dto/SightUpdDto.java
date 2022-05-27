package com.example.sights.model.dto;

import com.example.sights.model.Sight;

public class SightUpdDto {

    private String description;

    public SightUpdDto(Sight sight) {
        this.description = sight.getDescription();
    }

    public String getDescription() {
        return description;
    }

}
