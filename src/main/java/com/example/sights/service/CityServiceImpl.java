package com.example.sights.service;

import com.example.sights.model.City;
import com.example.sights.model.dto.CityDto;
import com.example.sights.model.dto.CityUpdDto;
import com.example.sights.model.dto.SightDto;
import com.example.sights.model.dto.SightUpdDto;
import com.example.sights.repos.CitiesRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CitiesRepo citiesRepo;

    public CityServiceImpl(CitiesRepo citiesRepo) {
        this.citiesRepo = citiesRepo;
    }
    @Transactional
    @Override
    public void create(CityDto city) {
        citiesRepo.save(city);
    }
    @Transactional
    @Override
    public List<CityDto> readAll() {return citiesRepo.findAll();}
    @Transactional
    @Override
    public CityDto read(Long id) {
        return citiesRepo.getReferenceById(id);
    }
    @Transactional
    @Override
    public void update(CityUpdDto dto, Long id) {
        CityDto sight = citiesRepo.findById(id)
                .orElseThrow(EntityExistsException::new);
        sight.setNumPopulation(dto.getNumPopulation());
        sight.setAvailabilityMetro(dto.isAvailabilityMetro());
    }

    @Transactional
    @Override
    public boolean delete(Long id) {
        if(citiesRepo.existsById(id)) {
            citiesRepo.existsById(id);
            return true;
        }
        return false;
    }

}
