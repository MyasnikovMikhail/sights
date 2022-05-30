package com.example.sights.controller;

import com.example.sights.model.dto.CityDto;
import com.example.sights.model.dto.CityUpdDto;
import com.example.sights.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping(value="/cities")
    public void create(@RequestBody CityDto city) {
        cityService.create(city);
    }

    @GetMapping(value="/cities")
    public List<CityDto> readAll() {
        return cityService.readAll();
    }

    @GetMapping(value="/cities/{id}")
    public CityDto read(@PathVariable(name="id") Long id) {
        return cityService.read(id);
    }

    @PutMapping(value="/cities/{id}")
    public void update(@PathVariable(name="id") Long id, @RequestBody CityUpdDto city) {
        cityService.update(city,id);
    }

    @DeleteMapping(value="/cities/{id}")
    public void delete(@PathVariable(name="id") Long id) {
        cityService.delete(id);
    }
}
