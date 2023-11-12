package com.pelyshko.repository;

import org.springframework.stereotype.Repository;
import com.pelyshko.domain.CashWithdrawalFromLesseeToService;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CashWithdrawalFromLesseeToServiceRepository extends JpaRepository<CashWithdrawalFromLesseeToService, Integer> {
}
