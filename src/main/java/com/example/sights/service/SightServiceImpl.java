package com.example.sights.service;

import com.example.sights.model.City;
import com.example.sights.model.Sight;
import com.example.sights.model.dto.SightDto;
import com.example.sights.model.dto.SightUpdDto;
import com.example.sights.repos.CitiesRepo;
import com.example.sights.repos.SightsRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
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
    public void create(SightDto sight) {
        sightsRepo.save(sightDtoToSight(sight));
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
        return convertToSightDTO(sightsRepo.findById(id).get());
    }
    @Transactional
    @Override
    public void update(SightUpdDto dto, Long id) {
        Sight sight = sightsRepo.findById(id)
                .orElseThrow(EntityExistsException::new);
            sight.setDescription(dto.getDescription());
    }

    @Transactional
    @Override
    public boolean delete(Long id) {
        if(sightsRepo.existsById(id)) {
            sightsRepo.existsById(id);
            return true;
        }
        return false;
    }

    @Transactional
    public List<SightDto> getSightsByCity(Long cityId) {
        City cityRef = citiesRepo.getReferenceById(cityId);
        return sightsRepo.findByCity(cityRef)
                .stream()
                .map(this::convertToSightDTO)
                . collect (Collectors. toList());
    }

    private SightDto convertToSightDTO(Sight sight) {
        SightDto sightDto = new SightDto();
        sightDto.setId(sight.getId());
        sightDto.setNameSight(sight.getNameSight());
        sightDto.setDate(sight.getDate());
        sightDto.setDescription(sight.getDescription());
        sightDto.setType(sight.getType());
        sightDto.setCity(sight.getCity());
        return sightDto;
    }

    private Sight sightDtoToSight(SightDto sightDto) {
        Sight sight = new Sight();
        sight.setNameSight(sightDto.getNameSight());
        sight.setDate(sightDto.getDate());
        sight.setDescription(sightDto.getDescription());
        sight.setType(sightDto.getType());
        sight.setCity(sightDto.getCity());
        return sight;
    }
}
