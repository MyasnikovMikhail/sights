package com.example.sights.service;

import com.example.sights.model.dto.SightDto;
import com.example.sights.model.dto.SightUpdDto;

import java.util.List;

public interface SightService {
    void create(SightDto sight);

    List<SightDto> readAll();

    SightDto read(Long id);

    void update(SightUpdDto sight, Long id);

    void delete(Long id);
    List<SightDto> getSightsByCity (Long id);

}
