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

import com.pelyshko.domain.Lessee;
import com.pelyshko.dto.LesseeDto;
import com.pelyshko.dto.assembler.LesseeDtoAssembler;
import com.pelyshko.service.LesseeService;


@RestController
@RequestMapping(value = "/api/lessees")
public class LesseeController {
	@Autowired
    private LesseeService lesseeService;
    @Autowired
    private LesseeDtoAssembler lesseeDtoAssembler;

    @GetMapping(value = "/{lesseeId}")
    public ResponseEntity<LesseeDto> getLessee(@PathVariable Integer lesseeId) {
    	Lessee lessee = lesseeService.findById(lesseeId);
    	LesseeDto lesseeDto = lesseeDtoAssembler.toModel(lessee);
        return new ResponseEntity<>(lesseeDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<LesseeDto>> getAllLessees() {
        List<Lessee> lessees = lesseeService.findAll();
        CollectionModel<LesseeDto> lesseeDtos = lesseeDtoAssembler.toCollectionModel(lessees);
        return new ResponseEntity<>(lesseeDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<LesseeDto> addLessee(@RequestBody Lessee lessee) {
    	Lessee newLessee = lesseeService.create(lessee);
    	LesseeDto lesseeDto = lesseeDtoAssembler.toModel(newLessee);
        return new ResponseEntity<>(lesseeDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{lesseeId}")
    public ResponseEntity<?> updateLessee(@RequestBody Lessee updLessee, @PathVariable Integer lesseeId) {
    	lesseeService.update(lesseeId, updLessee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{lesseeId}")
    public ResponseEntity<?> deleteLessee(@PathVariable Integer lesseeId) {
    	lesseeService.delete(lesseeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
