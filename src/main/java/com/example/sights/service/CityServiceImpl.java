package com.example.sights.service;

import com.example.sights.model.City;
import com.example.sights.model.dto.CityDto;
import com.example.sights.repos.CitiesRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CitiesRepo citiesRepo;

    public CityServiceImpl(CitiesRepo citiesRepo) {
        this.citiesRepo = citiesRepo;
    }
    @Transactional
    @Override
    public void create(City city) {
        citiesRepo.save(city);
    }
    @Transactional
    @Override
    public List<City> readAll() {return citiesRepo.findAll();}
    @Transactional
    @Override
    public City read(Long id) {
        return citiesRepo.getReferenceById(id);
    }
    @Transactional
    @Override
    public boolean update(City city, Long id) {
        if (citiesRepo.existsById(id)) {
            city.setId(id);
            citiesRepo.save(city);
            return true;
        }

        return false;
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
