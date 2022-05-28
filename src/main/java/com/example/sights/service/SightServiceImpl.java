package com.example.sights.service;

import com.example.sights.model.Sight;
import com.example.sights.model.dto.CityDto;
import com.example.sights.model.dto.SightDto;
import com.example.sights.model.dto.SightUpdDto;
import com.example.sights.repos.SightsRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SightServiceImpl implements SightService{
    private final SightsRepo sightsRepo;

    public SightServiceImpl(SightsRepo sightsRepo) {this.sightsRepo = sightsRepo;}
    @Transactional
    @Override
    public void create(SightDto sight) {
        sightsRepo.save(SightDtoToSight(sight));
    }

    @Transactional
    @Override
    public List<SightDto> readAll() {
        return sightsRepo
                .findAll()
                .stream()
                .map(this::convertToSightDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public SightDto read(Long id) {
        return convertToSightDTO(sightsRepo.findById(id).get());
    }
    @Transactional
    @Override
    public void update(SightUpdDto dto, Long id) {
        Sight sight = sightsRepo.findById(id)
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

    private SightDto convertToSightDTO(Sight sight) {
        SightDto sightDto = new SightDto();
        sightDto.setId(sight.getId());
        sightDto.setNameSight(sight.getNameSight());
        sightDto.setDate(sight.getDate());
        sightDto.setDescription(sight.getDescription());
        sightDto.setType(sight.getType());
        sightDto.setCity(sight.getCity());
        return sightDto;
    }
    /*private SightUpdDto convertToSightUpdDTO(Sight sight) {
        SightUpdDto sightUpdDto = new SightUpdDto();
        sightUpdDto.setDescription(sight.getDescription());
        return sightUpdDto;
    }*/

    private Sight SightDtoToSight(SightDto sightDto) {
        Sight sight = new Sight();
        sight.setNameSight(sightDto.getNameSight());
        sight.setDate(sightDto.getDate());
        sight.setDescription(sightDto.getDescription());
        sight.setType(sightDto.getType());
        sight.setCity(sightDto.getCity());
        return sight;
    }
}
