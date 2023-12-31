package com.pelyshko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import com.pelyshko.domain.City;
import com.pelyshko.dto.CityDto;
import com.pelyshko.dto.assembler.CityDtoAssembler;
import com.pelyshko.service.CityService;


@RestController
@RequestMapping(value = "/api/cities")
public class CityController {
	@Autowired
    private CityService cityService;
    @Autowired
    private CityDtoAssembler cityDtoAssembler;

    @GetMapping(value = "/{cityId}")
    public ResponseEntity<CityDto> getCity(@PathVariable Integer cityId) {
    	City city = cityService.findById(cityId);
    	CityDto cityDto = cityDtoAssembler.toModel(city);
        return new ResponseEntity<>(cityDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<CityDto>> getAllCities() {
        List<City> cities = cityService.findAll();
        CollectionModel<CityDto> cityDtos = cityDtoAssembler.toCollectionModel(cities);
        return new ResponseEntity<>(cityDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<CityDto> addCity(@RequestBody City city) {
    	City newCity = cityService.create(city);
    	CityDto cityDto = cityDtoAssembler.toModel(newCity);
        return new ResponseEntity<>(cityDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{cityId}")
    public ResponseEntity<?> updateCity(@RequestBody City updCity, @PathVariable Integer cityId) {
    	cityService.update(cityId, updCity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{cityId}")
    public ResponseEntity<?> deleteCity(@PathVariable Integer cityId) {
    	cityService.delete(cityId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping(value = "/avg_population")
    public ResponseEntity<Double> getAvgPopulation() {
        double avgPopulation = cityService.getAvgPopulation();
        return new ResponseEntity<>(avgPopulation, HttpStatus.OK);
    }
}
