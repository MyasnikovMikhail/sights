package com.example.sights.repos;

import com.example.sights.model.City;
import com.example.sights.model.dto.CityDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitiesRepo extends JpaRepository<CityDto, Long> {
}
