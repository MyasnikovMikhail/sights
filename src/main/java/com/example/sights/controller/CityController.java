package com.example.sights.controller;

import com.example.sights.model.City;
import com.example.sights.model.dto.CityDto;
import com.example.sights.service.CityService;
import com.example.sights.service.SightService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping(value="/cities")
    public void create(@RequestBody CityDto cityDto) {
        cityService.create(cityDto);
    }

    @GetMapping(value="/cities")
    public ResponseEntity<List<CityDto>> read() {
        final List<CityDto> cities = cityService.readAll();

        return cities != null &&  !cities.isEmpty()
                ? new ResponseEntity<>(cities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/cities/{id}")
    public ResponseEntity<CityDto> read(@PathVariable(name="id") Long id) {
        final CityDto city = cityService.read(id);

        return city != null
                ? new ResponseEntity<>(city, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value="/cities/{id}")
    public void update(@PathVariable(name="id") Long id, @RequestBody City city) {
    }

    @DeleteMapping(value="/cities/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") Long id) {
        final boolean deleted = cityService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
