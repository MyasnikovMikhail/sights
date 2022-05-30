package com.example.sights.controller;

import com.example.sights.model.dto.SightDto;
import com.example.sights.model.dto.SightUpdDto;
import com.example.sights.service.SightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class SightController {

    private final SightService sightService;

    @Autowired
    public SightController(SightService sightService) {
        this.sightService = sightService;
    }

    @PostMapping(value="/sights")
    public void create(@RequestBody SightDto sight) {
        sightService.create(sight);

    }

    @GetMapping(value="/sights")
    public List<SightDto> readAll() {
        return sightService.readAll();
    }

    @GetMapping(value="/sights/{id}")
    public SightDto read(@PathVariable(name="id") Long id) {

        return sightService.read(id);
    }

    @GetMapping(value="/sights/by-city/{id}")
    public List<SightDto> sightsByCity(@PathVariable(name="id") Long id) {
        return sightService.getSightsByCity(id);
    }

    @PutMapping(value="/sights/{id}")
    public void update(@PathVariable(name="id") Long id, @RequestBody SightUpdDto sight) {
        sightService.update(sight,id);
    }

    @DeleteMapping(value="/sights/{id}")
    public void delete(@PathVariable(name="id") Long id) {
        sightService.delete(id);

    }
}
