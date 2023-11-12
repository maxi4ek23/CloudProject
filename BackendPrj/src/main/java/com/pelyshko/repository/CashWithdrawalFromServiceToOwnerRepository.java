package com.pelyshko.repository;

import org.springframework.stereotype.Repository;
import com.pelyshko.domain.CashWithdrawalFromServiceToOwner;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CashWithdrawalFromServiceToOwnerRepository extends JpaRepository<CashWithdrawalFromServiceToOwner, Integer> {
}
