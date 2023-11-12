package com.pelyshko.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelyshko.domain.DwellingOwner;
import com.pelyshko.exception.DwellingOwnerNotFoundException;
import com.pelyshko.repository.DwellingOwnerRepository;
import com.pelyshko.service.DwellingOwnerService;

@Service
public class DwellingOwnerServiceImpl implements DwellingOwnerService {
	@Autowired
	DwellingOwnerRepository dwellingOwnerRepository;
	
	@Override
	public DwellingOwner findById(Integer id) {
        return dwellingOwnerRepository.findById(id)
                .orElseThrow(() -> new DwellingOwnerNotFoundException(id));
    }
	
	@Override
    public List<DwellingOwner> findAll() {
        return dwellingOwnerRepository.findAll();
    }
	
	@Override
	@Transactional
	public DwellingOwner create(DwellingOwner dwellingOwner) {
		dwellingOwnerRepository.save(dwellingOwner);
        return dwellingOwner;
    }
	
	@Override
	@Transactional
    public void update(Integer id, DwellingOwner newDwellingOwner) {
		DwellingOwner dwellingOwner = dwellingOwnerRepository.findById(id)
                .orElseThrow(() -> new DwellingOwnerNotFoundException(id));
		dwellingOwner.setName(newDwellingOwner.getName());
		dwellingOwner.setSurname(newDwellingOwner.getSurname());
		dwellingOwnerRepository.save(dwellingOwner);
    }
	
	@Override
	@Transactional
	public void delete(Integer id) {
		DwellingOwner dwellingOwner = dwellingOwnerRepository.findById(id)
                .orElseThrow(() -> new DwellingOwnerNotFoundException(id));
		dwellingOwnerRepository.delete(dwellingOwner);
    }
}
