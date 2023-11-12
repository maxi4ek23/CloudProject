package com.pelyshko.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelyshko.domain.Lessee;
import com.pelyshko.exception.LesseeNotFoundException;
import com.pelyshko.repository.LesseeRepository;
import com.pelyshko.service.LesseeService;

@Service
public class LesseeServiceImpl implements LesseeService {
	@Autowired
	LesseeRepository lesseeRepository;
	
	@Override
	public Lessee findById(Integer id) {
        return lesseeRepository.findById(id)
                .orElseThrow(() -> new LesseeNotFoundException(id));
    }
	
	@Override
    public List<Lessee> findAll() {
        return lesseeRepository.findAll();
    }
	
	@Override
	@Transactional
	public Lessee create(Lessee lessee) {
		lesseeRepository.save(lessee);
        return lessee;
    }
	
	@Override
	@Transactional
    public void update(Integer id, Lessee newLessee) {
		Lessee lessee = lesseeRepository.findById(id)
                .orElseThrow(() -> new LesseeNotFoundException(id));
		lessee.setName(newLessee.getName());
		lessee.setSurname(newLessee.getSurname());
		lesseeRepository.save(lessee);
    }
	
	@Override
	@Transactional
	public void delete(Integer id) {
		Lessee lessee = lesseeRepository.findById(id)
                .orElseThrow(() -> new LesseeNotFoundException(id));
		lesseeRepository.delete(lessee);
    }
}
