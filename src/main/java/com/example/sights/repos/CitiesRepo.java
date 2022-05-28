package com.example.sights.repos;

import com.example.sights.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitiesRepo extends JpaRepository<City, Long> {

}
