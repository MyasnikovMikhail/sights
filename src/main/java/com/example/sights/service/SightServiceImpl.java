package com.example.sights.service;

import com.example.sights.model.Sight;
import com.example.sights.repos.SightsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SightServiceImpl implements SightService{
    private final SightsRepo sightsRepo;

    public SightServiceImpl(SightsRepo sightsRepo) {this.sightsRepo = sightsRepo;}

    @Override
    public void create(Sight sight) {sightsRepo.save(sight);}

    @Override
    public List<Sight> readAll() {
        return sightsRepo.findAll();
    }

    @Override
    public Sight read(Long id) {
        return sightsRepo.getReferenceById(id);
    }

    @Override
    public boolean update(Sight sight, Long id) {
        if (sightsRepo.existsById(id)) {
            sight.setId(id);
            sightsRepo.save(sight);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(Long id) {
        if(sightsRepo.existsById(id)) {
            sightsRepo.existsById(id);
            return true;
        }
        return false;
    }
}
