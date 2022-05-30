package com.example.sights.repos;


import com.example.sights.model.City;
import com.example.sights.model.Sight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SightsRepo extends JpaRepository<Sight, Long> {

    List<Sight> findByCity(City city);
}
