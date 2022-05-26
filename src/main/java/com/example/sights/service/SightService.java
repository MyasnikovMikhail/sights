package com.example.sights.service;

import com.example.sights.model.Sight;

import java.util.List;

public interface SightService {
    void create(Sight sight);

    List<Sight> readAll();

    Sight read(int id);

    boolean update(Sight sight, int id);

    boolean delete(int id);
}
