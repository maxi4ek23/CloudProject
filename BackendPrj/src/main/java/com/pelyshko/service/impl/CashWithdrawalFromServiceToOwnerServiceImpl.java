package com.pelyshko.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelyshko.domain.CashWithdrawalFromServiceToOwner;
import com.pelyshko.exception.CashWithdrawalFromServiceToOwnerNotFoundException;
import com.pelyshko.repository.CashWithdrawalFromServiceToOwnerRepository;
import com.pelyshko.service.CashWithdrawalFromServiceToOwnerService;

@Service
public class CashWithdrawalFromServiceToOwnerServiceImpl implements CashWithdrawalFromServiceToOwnerService {
	@Autowired
	CashWithdrawalFromServiceToOwnerRepository сashWithdrawalFromServiceToOwnerRepository;
	
	@Override
	public CashWithdrawalFromServiceToOwner findById(Integer id) {
        return сashWithdrawalFromServiceToOwnerRepository.findById(id)
                .orElseThrow(() -> new CashWithdrawalFromServiceToOwnerNotFoundException(id));
    }
	
	@Override
    public List<CashWithdrawalFromServiceToOwner> findAll() {
        return сashWithdrawalFromServiceToOwnerRepository.findAll();
    }
	
	@Override
	@Transactional
	public CashWithdrawalFromServiceToOwner create(CashWithdrawalFromServiceToOwner сashWithdrawalFromServiceToOwner) {
		сashWithdrawalFromServiceToOwnerRepository.save(сashWithdrawalFromServiceToOwner);
        return сashWithdrawalFromServiceToOwner;
    }
	
	@Override
	@Transactional
    public void update(Integer id, CashWithdrawalFromServiceToOwner newCashWithdrawalFromServiceToOwner) {
		CashWithdrawalFromServiceToOwner сashWithdrawalFromServiceToOwner = сashWithdrawalFromServiceToOwnerRepository.findById(id)
                .orElseThrow(() -> new CashWithdrawalFromServiceToOwnerNotFoundException(id));
		сashWithdrawalFromServiceToOwner.setPrice(newCashWithdrawalFromServiceToOwner.getPrice());
		сashWithdrawalFromServiceToOwnerRepository.save(сashWithdrawalFromServiceToOwner);
    }
	
	@Override
	@Transactional
	public void delete(Integer id) {
		CashWithdrawalFromServiceToOwner сashWithdrawalFromServiceToOwner = сashWithdrawalFromServiceToOwnerRepository.findById(id)
                .orElseThrow(() -> new CashWithdrawalFromServiceToOwnerNotFoundException(id));
		сashWithdrawalFromServiceToOwnerRepository.delete(сashWithdrawalFromServiceToOwner);
    }
}
