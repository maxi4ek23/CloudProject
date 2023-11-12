package com.pelyshko.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelyshko.domain.Country;
import com.pelyshko.exception.CountryNotFoundException;
import com.pelyshko.repository.CountryRepository;
import com.pelyshko.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {
	@Autowired
	CountryRepository countryRepository;
	
	@Override
	public Country findById(Integer id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id));
    }
	
	@Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }
	
	@Override
	@Transactional
	public Country create(Country country) {
		countryRepository.save(country);
        return country;
    }
	
	@Override
	@Transactional
    public void update(Integer id, Country newCountry) {
		Country country = countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id));
		country.setName(newCountry.getName());
		countryRepository.save(country);
    }
	
	@Override
	@Transactional
	public void delete(Integer id) {
		Country country = countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id));
		countryRepository.delete(country);
    }
	
	@Override 
	public void addCountryByProcedure(String name) {
		countryRepository.addCountryByProcedure(name);
	}
	
	@Override
	public void insertTenCountries() {
		countryRepository.insertTenCountries();
	}
	
	public void createTablesWithCursor() {
		countryRepository.createTablesWithCursor();
	}
}
