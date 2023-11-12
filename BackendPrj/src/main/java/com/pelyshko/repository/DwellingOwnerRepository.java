package com.pelyshko.repository;

import org.springframework.stereotype.Repository;
import com.pelyshko.domain.DwellingOwner;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DwellingOwnerRepository extends JpaRepository<DwellingOwner, Integer> {
	List<DwellingOwner> findBySurname(String surname);
}
