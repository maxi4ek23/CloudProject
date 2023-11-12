package com.pelyshko.repository;

import org.springframework.stereotype.Repository;
import com.pelyshko.domain.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Integer> {
}
