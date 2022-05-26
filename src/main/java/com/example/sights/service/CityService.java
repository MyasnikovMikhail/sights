package com.example.sights.service;

import com.example.sights.model.City;

import java.util.List;

public interface CityService {
    void create(City city);

    List<City> readAll();

    City read(Long id);

    boolean update(City city, Long id);

    boolean delete(Long id);

}
