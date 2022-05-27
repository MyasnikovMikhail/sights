package com.example.sights.service;

import com.example.sights.model.Sight;
import com.example.sights.model.dto.SightDto;
import com.example.sights.model.dto.SightUpdDto;
import com.example.sights.repos.SightsRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
public class SightServiceImpl implements SightService{
    private final SightsRepo sightsRepo;

    public SightServiceImpl(SightsRepo sightsRepo) {this.sightsRepo = sightsRepo;}
    @Transactional
    @Override
    public void create(SightDto sight) {sightsRepo.save(sight);}
    @Transactional
    @Override
    public List<SightDto> readAll() {
        return sightsRepo.findAll();
    }
    @Transactional
    @Override
    public SightDto read(Long id) {
        return sightsRepo.getReferenceById(id);
    }
    @Transactional
    @Override
    public void update(SightUpdDto dto, Long id) {
        SightDto sight = sightsRepo.findById(id)
                .orElseThrow(EntityExistsException::new);
            sight.setDescription(dto.getDescription());
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
