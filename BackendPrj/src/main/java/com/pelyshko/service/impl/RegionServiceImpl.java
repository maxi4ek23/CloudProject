package com.pelyshko.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelyshko.domain.Region;
import com.pelyshko.exception.RegionNotFoundException;
import com.pelyshko.repository.RegionRepository;
import com.pelyshko.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService {
	@Autowired
	RegionRepository regionRepository;
	
	@Override
	public Region findById(Integer id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new RegionNotFoundException(id));
    }
	
	@Override
    public List<Region> findAll() {
        return regionRepository.findAll();
    }
	
	@Override
	@Transactional
	public Region create(Region region) {
		regionRepository.save(region);
        return region;
    }
	
	@Override
	@Transactional
    public void update(Integer id, Region newRegion) {
		Region region = regionRepository.findById(id)
                .orElseThrow(() -> new RegionNotFoundException(id));
		region.setName(newRegion.getName());
		regionRepository.save(region);
    }
	
	@Override
	@Transactional
	public void delete(Integer id) {
		Region region = regionRepository.findById(id)
                .orElseThrow(() -> new RegionNotFoundException(id));
		regionRepository.delete(region);
    }
}
