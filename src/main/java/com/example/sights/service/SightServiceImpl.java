package com.example.sights.service;

import com.example.sights.model.Sight;
import com.example.sights.repos.SightsRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SightServiceImpl implements SightService{
    private final SightsRepo sightsRepo;

    public SightServiceImpl(SightsRepo sightsRepo) {this.sightsRepo = sightsRepo;}
    @Transactional
    @Override
    public void create(Sight sight) {sightsRepo.save(sight);}
    @Transactional
    @Override
    public List<Sight> readAll() {
        return sightsRepo.findAll();
    }
    @Transactional
    @Override
    public Sight read(Long id) {
        return sightsRepo.getReferenceById(id);
    }
    @Transactional
    @Override
    public boolean update(Sight sight, Long id) {
        if (sightsRepo.existsById(id)) {
            sight.setId(id);
            sightsRepo.save(sight);
            return true;
        }

        return false;
    }
    @Transactional
    @Override
    public boolean delete(Long id) {
        if(sightsRepo.existsById(id)) {
            sightsRepo.existsById(id);
            return true;
        }
        return false;
    }
}
