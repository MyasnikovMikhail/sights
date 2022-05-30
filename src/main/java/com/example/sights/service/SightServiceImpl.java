package com.example.sights.service;

import com.example.sights.exceptions.NoSuchObjectException;
import com.example.sights.model.City;
import com.example.sights.model.Sight;
import com.example.sights.model.dto.SightDto;
import com.example.sights.model.dto.SightUpdDto;
import com.example.sights.repos.CitiesRepo;
import com.example.sights.repos.SightsRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SightServiceImpl implements SightService{

    private final SightsRepo sightsRepo;

    private final CitiesRepo citiesRepo;

    public SightServiceImpl(SightsRepo sightsRepo, CitiesRepo citiesRepo) {this.sightsRepo = sightsRepo;
        this.citiesRepo = citiesRepo;
    }

    @Transactional
    @Override
    public void create(SightDto dto) {
        City city = citiesRepo.getReferenceById(dto.getCityId());
        Sight sight = sightDtoToSight(dto);
        sight.setCity(city);
        sightsRepo.save(sight);
    }

    @Transactional
    @Override
    public List<SightDto> readAll() {
        return sightsRepo
                .findAll()
                .stream()
                .map(this::convertToSightDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public SightDto read(Long id) {
        Sight sight = sightsRepo.findById(id)
                .orElseThrow(() -> new NoSuchObjectException("There is no sight with ID = " + id + " in Database"));
        return convertToSightDTO(sight);
    }

    @Transactional
    @Override
    public void update(SightUpdDto dto, Long id) {
        Sight sight = sightsRepo.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        sight.setDescription(dto.getDescription());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        sightsRepo.deleteById(id);
    }

    @Transactional
    public List<SightDto> getSightsByCity(Long cityId) {
        City cityRef = citiesRepo.getReferenceById(cityId);
        return sightsRepo.findByCity(cityRef)
                .stream()
                .map(this::convertToSightDTO)
                .collect (Collectors. toList());
    }

    private SightDto convertToSightDTO(Sight sight) {
        SightDto sightDto = new SightDto();
        sightDto.setId(sight.getId());
        sightDto.setNameSight(sight.getNameSight());
        sightDto.setDate(sight.getDate());
        sightDto.setDescription(sight.getDescription());
        sightDto.setType(sight.getType());
        sightDto.setCityId(sight.getCity().getId());
        return sightDto;
    }

    private Sight sightDtoToSight(SightDto sightDto) {
        Sight sight = new Sight();
        sight.setNameSight(sightDto.getNameSight());
        sight.setDate(sightDto.getDate());
        sight.setDescription(sightDto.getDescription());
        sight.setType(sightDto.getType());
        return sight;
    }
}
