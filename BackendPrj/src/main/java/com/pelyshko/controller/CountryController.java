package com.pelyshko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pelyshko.domain.Country;
import com.pelyshko.dto.CountryDto;
import com.pelyshko.dto.assembler.CountryDtoAssembler;
import com.pelyshko.service.CountryService;


@RestController
@RequestMapping(value = "/api/countries")
public class CountryController {
	@Autowired
    private CountryService countryService;
    @Autowired
    private CountryDtoAssembler countryDtoAssembler;

    @GetMapping(value = "/{countryId}")
    public ResponseEntity<CountryDto> getCountry(@PathVariable Integer countryId) {
    	Country country = countryService.findById(countryId);
    	CountryDto countryDto = countryDtoAssembler.toModel(country);
        return new ResponseEntity<>(countryDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<CountryDto>> getAllCountries() {
        List<Country> countries = countryService.findAll();
        CollectionModel<CountryDto> countryDtos = countryDtoAssembler.toCollectionModel(countries);
        return new ResponseEntity<>(countryDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<CountryDto> addCountry(@RequestBody Country country) {
    	Country newCountry = countryService.create(country);
    	CountryDto countryDto = countryDtoAssembler.toModel(newCountry);
        return new ResponseEntity<>(countryDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{countryId}")
    public ResponseEntity<?> updateCountry(@RequestBody Country updCountry, @PathVariable Integer countryId) {
    	countryService.update(countryId, updCountry);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{countryId}")
    public ResponseEntity<?> deleteCountry(@PathVariable Integer countryId) {
    	countryService.delete(countryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping(value = "/{countryId}")
    public ResponseEntity<?> addCountryByProcedure(@RequestBody Country country, @PathVariable Integer countryId) {
    	countryService.addCountryByProcedure(country.getName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PostMapping(value = "/tenField")
    public void insertTenCountries(){
        countryService.insertTenCountries();
    }
    
    @PostMapping(value = "/cursor")
    public ResponseEntity<?> createTablesWithCursor() {
        countryService.createTablesWithCursor();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
