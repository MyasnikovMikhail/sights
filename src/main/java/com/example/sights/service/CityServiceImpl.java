package com.example.sights.service;

import com.example.sights.model.City;
import com.example.sights.model.dto.CityDto;
import com.example.sights.model.dto.CityUpdDto;
import com.example.sights.model.dto.SightDto;
import com.example.sights.repos.CitiesRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    private final CitiesRepo citiesRepo;

    public CityServiceImpl(CitiesRepo citiesRepo) {
        this.citiesRepo = citiesRepo;
    }
    @Transactional
    @Override
    public void create(CityDto city) {
        citiesRepo.save(cityDtoToCity(city));
    }

    @Transactional
    @Override
    public List<CityDto> readAll() {
        return citiesRepo
            .findAll()
            .stream()
            .map(this::convertToCityDTO)
            .collect(Collectors.toList());}
    @Transactional
    @Override
    public CityDto read(Long id) {
        return convertToCityDTO(citiesRepo.findById(id).get());
    }
    @Transactional
    @Override
    public void update(CityUpdDto dto, Long id) {
        City city = citiesRepo.findById(id)
                .orElseThrow(EntityExistsException::new);
        city.setNumPopulation(dto.getNumPopulation());
        city.setAvailabilityMetro(dto.isAvailabilityMetro());
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



    private CityDto convertToCityDTO(City city) {
        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId());
        cityDto.setNameCity(city.getNameCity());
        cityDto.setNumPopulation(city.getNumPopulation());
        cityDto.setAvailabilityMetro(city.isAvailabilityMetro());
        cityDto.setCountry(city.getCountry());
        return cityDto;
    }

    private City cityDtoToCity(CityDto cityDto) {
        City city = new City();
        city.setNameCity(cityDto.getNameCity());
        city.setNumPopulation(cityDto.getNumPopulation());
        city.setAvailabilityMetro(cityDto.isAvailabilityMetro());
        city.setCountry(cityDto.getCountry());
        return city;

    }



}
