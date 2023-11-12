package com.pelyshko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pelyshko.domain.PlatformUser;
import com.pelyshko.dto.PlatformUserDto;
import com.pelyshko.dto.assembler.PlatformUserDtoAssembler;
import com.pelyshko.service.PlatformUserService;


@RestController
@RequestMapping(value = "/api/platformUsers")
public class PlatformUserController {
	@Autowired
    private PlatformUserService platformUserService;
    @Autowired
    private PlatformUserDtoAssembler platformUserDtoAssembler;

    @GetMapping(value = "/{platformUserId}")
    public ResponseEntity<PlatformUserDto> getPlatformUser(@PathVariable Integer platformUserId) {
    	PlatformUser platformUser = platformUserService.findById(platformUserId);
    	PlatformUserDto platformUserDto = platformUserDtoAssembler.toModel(platformUser);
        return new ResponseEntity<>(platformUserDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<PlatformUserDto>> getAllPlatformUsers() {
        List<PlatformUser> platformUsers = platformUserService.findAll();
        CollectionModel<PlatformUserDto> platformUserDtos = platformUserDtoAssembler.toCollectionModel(platformUsers);
        return new ResponseEntity<>(platformUserDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<PlatformUserDto> addPlatformUser(@RequestBody PlatformUser platformUser) {
    	PlatformUser newPlatformUser = platformUserService.create(platformUser);
    	PlatformUserDto platformUserDto = platformUserDtoAssembler.toModel(newPlatformUser);
        return new ResponseEntity<>(platformUserDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{platformUserId}")
    public ResponseEntity<?> updatePlatformUser(@RequestBody PlatformUser updPlatformUser, @PathVariable Integer platformUserId) {
    	platformUserService.update(platformUserId, updPlatformUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{platformUserId}")
    public ResponseEntity<?> deletePlatformUser(@PathVariable Integer platformUserId) {
    	platformUserService.delete(platformUserId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
