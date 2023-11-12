package com.pelyshko.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelyshko.domain.City;
import com.pelyshko.exception.CityNotFoundException;
import com.pelyshko.repository.CityRepository;
import com.pelyshko.service.CityService;

@Service
public class CityServiceImpl implements CityService {
	@Autowired
	CityRepository cityRepository;
	
	@Override
	public City findById(Integer id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
    }
	
	@Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }
	
	@Override
	@Transactional
	public City create(City city) {
		cityRepository.save(city);
        return city;
    }
	
	@Override
	@Transactional
    public void update(Integer id, City newCity) {
		City city = cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
		city.setName(newCity.getName());
		cityRepository.save(city);
    }
	
	@Override
	@Transactional
	public void delete(Integer id) {
		City city = cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
		cityRepository.delete(city);
    }
	
	@Override
	public Double getAvgPopulation() {
		return cityRepository.getAvgPopulation();
	}
}
