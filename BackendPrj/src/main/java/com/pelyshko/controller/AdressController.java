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

import com.pelyshko.domain.Adress;
import com.pelyshko.dto.AdressDto;
import com.pelyshko.dto.assembler.AdressDtoAssembler;
import com.pelyshko.service.AdressService;


@RestController
@RequestMapping(value = "/api/adresses")
public class AdressController {
	@Autowired
    private AdressService adressService;
    @Autowired
    private AdressDtoAssembler adressDtoAssembler;

    @GetMapping(value = "/{adressId}")
    public ResponseEntity<AdressDto> getAdress(@PathVariable Integer adressId) {
    	Adress adress = adressService.findById(adressId);
    	AdressDto adressDto = adressDtoAssembler.toModel(adress);
        return new ResponseEntity<>(adressDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<AdressDto>> getAllAdresses() {
        List<Adress> adresses = adressService.findAll();
        CollectionModel<AdressDto> adressDtos = adressDtoAssembler.toCollectionModel(adresses);
        return new ResponseEntity<>(adressDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<AdressDto> addAdress(@RequestBody Adress adress) {
    	Adress newAdress = adressService.create(adress);
    	AdressDto adressDto = adressDtoAssembler.toModel(newAdress);
        return new ResponseEntity<>(adressDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{adressId}")
    public ResponseEntity<?> updateAdress(@RequestBody Adress updAdress, @PathVariable Integer adressId) {
    	adressService.update(adressId, updAdress);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{adressId}")
    public ResponseEntity<?> deleteAdress(@PathVariable Integer adressId) {
    	adressService.delete(adressId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
