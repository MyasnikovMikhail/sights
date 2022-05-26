package com.example.sights.service;

import com.example.sights.model.City;
import com.example.sights.repos.CitiesRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CitiesRepo citiesRepo;

    public CityServiceImpl(CitiesRepo citiesRepo) {
        this.citiesRepo = citiesRepo;
    }

    @Override
    public void create(City city) {
        citiesRepo.save(city);
    }

    @Override
    public List<City> readAll() {return citiesRepo.findAll();}

    @Override
    public City read(Long id) {
        return citiesRepo.getReferenceById(id);
    }

    @Override
    public boolean update(City city, Long id) {
        if (citiesRepo.existsById(id)) {
            city.setId(id);
            citiesRepo.save(city);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(Long id) {
        if(citiesRepo.existsById(id)) {
            citiesRepo.existsById(id);
            return true;
        }
        return false;
    }
}
