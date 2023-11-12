package com.pelyshko.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelyshko.domain.PlatformUser;
import com.pelyshko.exception.PlatformUserNotFoundException;
import com.pelyshko.repository.PlatformUserRepository;
import com.pelyshko.service.PlatformUserService;

@Service
public class PlatformUserServiceImpl implements PlatformUserService {
	@Autowired
	PlatformUserRepository platformUserRepository;
	
	@Override
	public PlatformUser findById(Integer id) {
        return platformUserRepository.findById(id)
                .orElseThrow(() -> new PlatformUserNotFoundException(id));
    }
	
	@Override
    public List<PlatformUser> findAll() {
        return platformUserRepository.findAll();
    }
	
	@Override
	@Transactional
	public PlatformUser create(PlatformUser platformUser) {
		platformUserRepository.save(platformUser);
        return platformUser;
    }
	
	@Override
	@Transactional
    public void update(Integer id, PlatformUser newPlatformUser) {
		PlatformUser platformUser = platformUserRepository.findById(id)
                .orElseThrow(() -> new PlatformUserNotFoundException(id));
		platformUser.setEmail(newPlatformUser.getEmail());
		platformUser.setPhone(newPlatformUser.getPhone());
		platformUserRepository.save(platformUser);
    }
	
	@Override
	@Transactional
	public void delete(Integer id) {
		PlatformUser platformUser = platformUserRepository.findById(id)
                .orElseThrow(() -> new PlatformUserNotFoundException(id));
		platformUserRepository.delete(platformUser);
    }
}
