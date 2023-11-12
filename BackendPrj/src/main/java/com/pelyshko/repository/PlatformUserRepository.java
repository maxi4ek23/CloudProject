package com.pelyshko.repository;

import org.springframework.stereotype.Repository;
import com.pelyshko.domain.PlatformUser;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PlatformUserRepository extends JpaRepository<PlatformUser, Integer> {
}
