package com.example.sights.repos;

import com.example.sights.domain.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepo extends CrudRepository<City, Long> {
}
