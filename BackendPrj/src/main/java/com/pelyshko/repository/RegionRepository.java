package com.pelyshko.repository;

import org.springframework.stereotype.Repository;
import com.pelyshko.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
}
