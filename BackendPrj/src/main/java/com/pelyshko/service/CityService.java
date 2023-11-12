package com.pelyshko.service;

import com.pelyshko.domain.City;

public interface CityService extends GeneralService<City, Integer> {
	Double getAvgPopulation();
}
