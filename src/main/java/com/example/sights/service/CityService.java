package com.example.sights.service;

import com.example.sights.model.City;
import com.example.sights.model.dto.CityDto;
import com.example.sights.model.dto.CityUpdDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CityService {
    void create(CityDto city);

    List<CityDto> readAll();

    CityDto read(Long id);

    void update(CityUpdDto city, Long id);

    boolean delete(Long id);

}
