package com.pelyshko.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelyshko.domain.Dwelling;
import com.pelyshko.domain.DwellingOwner;
import com.pelyshko.exception.DwellingNotFoundException;
import com.pelyshko.exception.DwellingOwnerNotFoundBySurnameException;
import com.pelyshko.repository.DwellingOwnerRepository;
import com.pelyshko.repository.DwellingRepository;
import com.pelyshko.service.DwellingService;

@Service
public class DwellingServiceImpl implements DwellingService {
	@Autowired
	DwellingRepository dwellingRepository;
	@Autowired
	DwellingOwnerRepository dwellingOwnerRepository;
	
	@Override
	public Dwelling findById(Integer id) {
        return dwellingRepository.findById(id)
                .orElseThrow(() -> new DwellingNotFoundException(id));
    }
	
	@Override
    public List<Dwelling> findAll() {
        return dwellingRepository.findAll();
    }
	
	@Override
	@Transactional
	public Dwelling create(Dwelling dwelling) {
		dwellingRepository.save(dwelling);
        return dwelling;
    }
	
	@Override
	@Transactional
    public void update(Integer id, Dwelling newDwelling) {
		Dwelling dwelling = dwellingRepository.findById(id)
                .orElseThrow(() -> new DwellingNotFoundException(id));
		dwelling.setArea(newDwelling.getArea());
		dwelling.setFloor(newDwelling.getFloor());
		dwelling.setRoomsNumber(newDwelling.getRoomsNumber());
		dwelling.setDescription(newDwelling.getDescription());
		dwellingRepository.save(dwelling);
    }
	
	@Override
	@Transactional
	public void delete(Integer id) {
		Dwelling dwelling = dwellingRepository.findById(id)
                .orElseThrow(() -> new DwellingNotFoundException(id));
		dwellingRepository.delete(dwelling);
    }
	
	public List<Dwelling> findDwellingsByDwellingOwnerSurname(String dwellingOwnerSurname) {
		List<DwellingOwner> dwellingOwners = dwellingOwnerRepository.findBySurname(dwellingOwnerSurname);
        if(dwellingOwners.isEmpty()) throw new DwellingOwnerNotFoundBySurnameException(dwellingOwnerSurname);
        
        return dwellingOwners.stream().map(dwellingOwner -> dwellingOwner.getDwellings()).flatMap(Collection::stream).collect(Collectors.toList());
	}
	
	@Override
	public void createManyToManyRelationship(Integer dwellId, Integer userId) {
		dwellingRepository.createManyToManyRelationship(dwellId, userId);
	}
}
