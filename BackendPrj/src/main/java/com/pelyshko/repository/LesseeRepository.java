package com.pelyshko.repository;

import org.springframework.stereotype.Repository;
import com.pelyshko.domain.Lessee;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LesseeRepository extends JpaRepository<Lessee, Integer> {
}
