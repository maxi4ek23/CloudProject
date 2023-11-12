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

import com.pelyshko.domain.Dwelling;
import com.pelyshko.domain.PlatformUser;
import com.pelyshko.dto.DwellingDto;
import com.pelyshko.dto.PlatformUserDto;
import com.pelyshko.dto.assembler.DwellingDtoAssembler;
import com.pelyshko.service.DwellingService;

import net.minidev.json.JSONObject;


@RestController
@RequestMapping(value = "/api/dwellings")
public class DwellingController {
	@Autowired
    private DwellingService dwellingService;
    @Autowired
    private DwellingDtoAssembler dwellingDtoAssembler;

    @GetMapping(value = "/{dwellingId}")
    public ResponseEntity<DwellingDto> getDwelling(@PathVariable Integer dwellingId) {
    	Dwelling dwelling = dwellingService.findById(dwellingId);
    	DwellingDto dwellingDto = dwellingDtoAssembler.toModel(dwelling);
        return new ResponseEntity<>(dwellingDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<DwellingDto>> getAllDwellings() {
        List<Dwelling> dwellings = dwellingService.findAll();
        CollectionModel<DwellingDto> dwellingDtos = dwellingDtoAssembler.toCollectionModel(dwellings);
        return new ResponseEntity<>(dwellingDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<DwellingDto> addDwelling(@RequestBody Dwelling dwelling) {
    	Dwelling newDwelling = dwellingService.create(dwelling);
    	DwellingDto dwellingDto = dwellingDtoAssembler.toModel(newDwelling);
        return new ResponseEntity<>(dwellingDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{dwellingId}")
    public ResponseEntity<?> updateDwelling(@RequestBody Dwelling updDwelling, @PathVariable Integer dwellingId) {
    	dwellingService.update(dwellingId, updDwelling);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{dwellingId}")
    public ResponseEntity<?> deleteDwelling(@PathVariable Integer dwellingId) {
    	dwellingService.delete(dwellingId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping(value = "/dwellingOwners{dwellingOwnerSurname}")
    public ResponseEntity<CollectionModel<DwellingDto>> getAllDwellingsByDwellingOwnerSurname(@PathVariable String dwellingOwnerSurname) {
    	List<Dwelling> dwellingsList = dwellingService.findDwellingsByDwellingOwnerSurname(dwellingOwnerSurname);
    	CollectionModel<DwellingDto> dwellingDtos = dwellingDtoAssembler.toCollectionModel(dwellingsList);
    	return new ResponseEntity<>(dwellingDtos, HttpStatus.OK);
    }
    
    @PostMapping(value = "/manyToManyRelationship")
    public void createManyToManyRelationShip( Integer dwellId, Integer userId) {
    	dwellingService.createManyToManyRelationship(dwellId ,userId);
  
    }
}
