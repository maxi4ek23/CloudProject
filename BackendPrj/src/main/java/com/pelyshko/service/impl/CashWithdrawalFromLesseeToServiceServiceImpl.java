package com.pelyshko.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelyshko.domain.CashWithdrawalFromLesseeToService;
import com.pelyshko.exception.CashWithdrawalFromLesseeToServiceNotFoundException;
import com.pelyshko.exception.CityNotFoundException;
import com.pelyshko.repository.CashWithdrawalFromLesseeToServiceRepository;
import com.pelyshko.service.CashWithdrawalFromLesseeToServiceService;

@Service
public class CashWithdrawalFromLesseeToServiceServiceImpl implements CashWithdrawalFromLesseeToServiceService {
	@Autowired
	CashWithdrawalFromLesseeToServiceRepository cashWithdrawalFromLesseeToServiceRepository;
	
	@Override
	public CashWithdrawalFromLesseeToService findById(Integer id) {
        return cashWithdrawalFromLesseeToServiceRepository.findById(id)
                .orElseThrow(() -> new CashWithdrawalFromLesseeToServiceNotFoundException(id));
    }
	
	@Override
    public List<CashWithdrawalFromLesseeToService> findAll() {
        return cashWithdrawalFromLesseeToServiceRepository.findAll();
    }
	
	@Override
	@Transactional
	public CashWithdrawalFromLesseeToService create(CashWithdrawalFromLesseeToService cashWithdrawalFromLesseeToService) {
		cashWithdrawalFromLesseeToServiceRepository.save(cashWithdrawalFromLesseeToService);
        return cashWithdrawalFromLesseeToService;
    }
	
	@Override
	@Transactional
    public void update(Integer id, CashWithdrawalFromLesseeToService newCashWithdrawalFromLesseeToService) {
		CashWithdrawalFromLesseeToService cashWithdrawalFromLesseeToService = cashWithdrawalFromLesseeToServiceRepository.findById(id)
                .orElseThrow(() -> new CashWithdrawalFromLesseeToServiceNotFoundException(id));
		cashWithdrawalFromLesseeToService.setPrice(newCashWithdrawalFromLesseeToService.getPrice());
		cashWithdrawalFromLesseeToServiceRepository.save(cashWithdrawalFromLesseeToService);
    }
	
	@Override
	@Transactional
	public void delete(Integer id) {
		CashWithdrawalFromLesseeToService cashWithdrawalFromLesseeToService = cashWithdrawalFromLesseeToServiceRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
		cashWithdrawalFromLesseeToServiceRepository.delete(cashWithdrawalFromLesseeToService);
    }
}
