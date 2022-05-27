package com.example.sights.controller;

import com.example.sights.model.dto.SightDto;
import com.example.sights.model.dto.SightUpdDto;
import com.example.sights.service.SightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequiredArgsConstructor
public class SightController {

    private final SightService sightService;

    @Autowired
    public SightController(SightService sightService) {
        this.sightService = sightService;
    }

    @PostMapping(value="/sights")
    public void create(@RequestBody SightDto sightDto) {
        sightService.create(sightDto);
    }

    @GetMapping(value="/sights")
    public ResponseEntity<List<?>> read() {
        final List<SightDto> sights = sightService.readAll();

        return sights != null &&  !sights.isEmpty()
                ? new ResponseEntity<>(sights, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value="/sights/{id}")
    public ResponseEntity<?> read(@PathVariable(name="id") Long id) {
        final SightDto sight = sightService.read(id);
        return sight != null
                ? new ResponseEntity<>(sight, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value="/sights/{id}")
    public void update(@PathVariable(name="id") Long id, @RequestBody SightUpdDto sight) {

    }

    @DeleteMapping(value="/sights/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") Long id) {
        final boolean deleted = sightService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
