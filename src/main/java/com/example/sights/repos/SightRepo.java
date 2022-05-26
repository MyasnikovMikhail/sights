package com.example.sights.repos;

import com.example.sights.domain.Sight;
import org.springframework.data.repository.CrudRepository;

public interface SightRepo extends CrudRepository<Sight, Long> {
}
