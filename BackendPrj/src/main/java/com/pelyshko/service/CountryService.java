package com.pelyshko.service;


import com.pelyshko.domain.Country;

public interface CountryService extends GeneralService<Country, Integer> {
	void addCountryByProcedure(String name);
	void insertTenCountries();
	void createTablesWithCursor();
}
