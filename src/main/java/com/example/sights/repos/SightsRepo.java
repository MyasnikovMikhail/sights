package com.example.sights.repos;


import com.example.sights.model.Sight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SightsRepo extends JpaRepository<Sight, Integer> {
}
