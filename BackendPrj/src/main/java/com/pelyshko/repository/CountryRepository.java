package com.pelyshko.repository;

import org.springframework.stereotype.Repository;

import com.pelyshko.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
	@Procedure("add_country")
	void addCountryByProcedure(String name);
	
	@Procedure("insert_10row_into_country")
	void insertTenCountries();
	
	@Procedure("create_tables_with_cursor")
    void createTablesWithCursor();
}
