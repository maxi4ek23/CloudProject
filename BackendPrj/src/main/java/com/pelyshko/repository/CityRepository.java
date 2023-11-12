package com.pelyshko.repository;

import org.springframework.stereotype.Repository;

import com.pelyshko.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
	@Query(value = "CALL get_avg_population_procedure();", nativeQuery = true)
	Double getAvgPopulation();
}
