package com.example.del.controller;

import com.example.del.entity.City;
import com.example.del.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @PostMapping
    public City createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable Long id) {
        return cityService.getCityById(id);
    }
}
