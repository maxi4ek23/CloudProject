package com.pelyshko.repository;

import org.springframework.stereotype.Repository;
import com.pelyshko.domain.Dwelling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

@Repository
public interface DwellingRepository extends JpaRepository<Dwelling, Integer> {
	@Procedure("create_user_dwelling_relationship")
	void createManyToManyRelationship(Integer dwellId, Integer userId);
	
}
