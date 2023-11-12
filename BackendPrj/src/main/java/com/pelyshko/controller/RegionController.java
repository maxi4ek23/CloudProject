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

import com.pelyshko.domain.Region;
import com.pelyshko.dto.RegionDto;
import com.pelyshko.dto.assembler.RegionDtoAssembler;
import com.pelyshko.service.RegionService;


@RestController
@RequestMapping(value = "/api/regions")
public class RegionController {
	@Autowired
    private RegionService regionService;
    @Autowired
    private RegionDtoAssembler regionDtoAssembler;

    @GetMapping(value = "/{regionId}")
    public ResponseEntity<RegionDto> getRegion(@PathVariable Integer regionId) {
    	Region region = regionService.findById(regionId);
    	RegionDto regionDto = regionDtoAssembler.toModel(region);
        return new ResponseEntity<>(regionDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<RegionDto>> getAllRegions() {
        List<Region> regions = regionService.findAll();
        CollectionModel<RegionDto> regionDtos = regionDtoAssembler.toCollectionModel(regions);
        return new ResponseEntity<>(regionDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<RegionDto> addRegion(@RequestBody Region region) {
    	Region newRegion = regionService.create(region);
    	RegionDto regionDto = regionDtoAssembler.toModel(newRegion);
        return new ResponseEntity<>(regionDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{regionId}")
    public ResponseEntity<?> updateRegion(@RequestBody Region updRegion, @PathVariable Integer regionId) {
    	regionService.update(regionId, updRegion);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{regionId}")
    public ResponseEntity<?> deleteRegion(@PathVariable Integer regionId) {
    	regionService.delete(regionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
