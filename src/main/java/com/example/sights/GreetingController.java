package com.example.sights;

import com.example.sights.domain.City;
import com.example.sights.domain.Sight;
import com.example.sights.domain.TypeSight;
import com.example.sights.repos.CityRepo;
import com.example.sights.repos.SightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private SightRepo sightRepo;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<City> cities = cityRepo.findAll();
        model.put("cities",cities);
        Iterable<Sight> sights = sightRepo.findAll();
        model.put("sight", sights);
        return"main";
    }

    @PostMapping
    public String addCity(@RequestParam String nameCity,
                          @RequestParam Long numPopulation,
                          @RequestParam boolean availabilityMetro,
                          @RequestParam String country,
                          Map<String, Object> model) {
        City city = new City(nameCity, numPopulation, availabilityMetro, country);

        cityRepo.save(city);

        Iterable<City> cities = cityRepo.findAll();
        model.put("cities",cities);

        return "main";
    }

    /*@PostMapping
    public String addSight(@RequestParam String nameSight,
                          @RequestParam Date date,
                          @RequestParam String description,
                          @RequestParam TypeSight type,
                           @RequestParam City city,
                           Map<String, Object> model) {
        Sight sight = new Sight(nameSight, date, description, type, city);

        sightRepo.save(sight);

        Iterable<Sight> sights = sightRepo.findAll();
        model.put("sight", sights);
        return "main";
    }*/

}