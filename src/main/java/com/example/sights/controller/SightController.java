package com.example.sights.controller;

import com.example.sights.model.Sight;
import com.example.sights.service.SightService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SightController {

    SightService sightService;

    /*@Autowired
    public SightController(SightService sightService) {
        this.sightService = sightService;
    }*/

    @PostMapping(value="/sights")
    public ResponseEntity<?> create(@RequestBody Sight sight) {
        sightService.create(sight);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value="/sights")
    public ResponseEntity<List<Sight>> read() {
        final List<Sight> sights = sightService.readAll();

        return sights != null &&  !sights.isEmpty()
                ? new ResponseEntity<>(sights, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value="/sights/{id}")
    public ResponseEntity<Sight> read(@PathVariable(name="id") Long id) {
        final Sight sight = sightService.read(id);

        return sight != null
                ? new ResponseEntity<>(sight, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value="/sights/{id}")
    public ResponseEntity<?> update(@PathVariable(name="id") Long id, @RequestBody Sight sight) {
        final boolean updated = sightService.update(sight, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value="/sights/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") Long id) {
        final boolean deleted = sightService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
