package com.pelyshko.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelyshko.domain.Adress;
import com.pelyshko.exception.AdressNotFoundException;
import com.pelyshko.repository.AdressRepository;
import com.pelyshko.service.AdressService;

@Service
public class AdressServiceImpl implements AdressService {
	@Autowired
	AdressRepository adressRepository;
	
	@Override
	public Adress findById(Integer id) {
        return adressRepository.findById(id)
                .orElseThrow(() -> new AdressNotFoundException(id));
    }
	
	@Override
    public List<Adress> findAll() {
        return adressRepository.findAll();
    }
	
	@Override
	@Transactional
	public Adress create(Adress adress) {
		adressRepository.save(adress);
        return adress;
    }
	
	@Override
	@Transactional
    public void update(Integer id, Adress newAdress) {
		Adress adress = adressRepository.findById(id)
                .orElseThrow(() -> new AdressNotFoundException(id));
		adress.setStreet(newAdress.getStreet());
		adress.setHouseNumber(newAdress.getHouseNumber());
		adressRepository.save(adress);
    }
	
	@Override
	@Transactional
	public void delete(Integer id) {
		Adress adress = adressRepository.findById(id)
                .orElseThrow(() -> new AdressNotFoundException(id));
		adressRepository.delete(adress);
    }
}
