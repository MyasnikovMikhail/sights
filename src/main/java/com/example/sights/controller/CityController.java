package com.example.sights.controller;

import com.example.sights.model.City;
import com.example.sights.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {
    @Autowired
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping(value = "/cities")
    public ResponseEntity<?> create(@RequestBody City city) {
        cityService.create(city);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/cities")
    public ResponseEntity<List<City>> read() {
        final List<City> cities = cityService.readAll();

        return cities != null &&  !cities.isEmpty()
                ? new ResponseEntity<>(cities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/cities/{id}")
    public ResponseEntity<City> read(@PathVariable(name = "id") int id) {
        final City city = cityService.read(id);

        return city != null
                ? new ResponseEntity<>(city, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/cities/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody City city) {
        final boolean updated = cityService.update(city, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/cities/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = cityService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
