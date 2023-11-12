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

import com.pelyshko.domain.DwellingOwner;
import com.pelyshko.dto.DwellingOwnerDto;
import com.pelyshko.dto.assembler.DwellingOwnerDtoAssembler;
import com.pelyshko.service.DwellingOwnerService;

@RestController
@RequestMapping(value = "/api/dwellingOwners")
public class DwellingOwnerController {
	@Autowired
    private DwellingOwnerService dwellingOwnerService;
    @Autowired
    private DwellingOwnerDtoAssembler dwellingOwnerDtoAssembler;

    @GetMapping(value = "/{dwellingOwnerId}")
    public ResponseEntity<DwellingOwnerDto> getDwellingOwner(@PathVariable Integer dwellingOwnerId) {
    	DwellingOwner dwellingOwner = dwellingOwnerService.findById(dwellingOwnerId);
    	DwellingOwnerDto dwellingOwnerDto = dwellingOwnerDtoAssembler.toModel(dwellingOwner);
        return new ResponseEntity<>(dwellingOwnerDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<DwellingOwnerDto>> getAllDwellingOwners() {
        List<DwellingOwner> dwellingOwners = dwellingOwnerService.findAll();
        CollectionModel<DwellingOwnerDto> dwellingOwnerDtos = dwellingOwnerDtoAssembler.toCollectionModel(dwellingOwners);
        return new ResponseEntity<>(dwellingOwnerDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<DwellingOwnerDto> addDwellingOwner(@RequestBody DwellingOwner dwellingOwner) {
    	DwellingOwner newDwellingOwner = dwellingOwnerService.create(dwellingOwner);
    	DwellingOwnerDto dwellingOwnerDto = dwellingOwnerDtoAssembler.toModel(newDwellingOwner);
        return new ResponseEntity<>(dwellingOwnerDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{dwellingOwnerId}")
    public ResponseEntity<?> updateDwellingOwner(@RequestBody DwellingOwner updDwellingOwner, @PathVariable Integer dwellingOwnerId) {
    	dwellingOwnerService.update(dwellingOwnerId, updDwellingOwner);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{dwellingOwnerId}")
    public ResponseEntity<?> deleteDwellingOwner(@PathVariable Integer dwellingOwnerId) {
    	dwellingOwnerService.delete(dwellingOwnerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
