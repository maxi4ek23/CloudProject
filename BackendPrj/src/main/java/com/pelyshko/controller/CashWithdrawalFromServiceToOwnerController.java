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

import com.pelyshko.domain.CashWithdrawalFromServiceToOwner;
import com.pelyshko.dto.CashWithdrawalFromServiceToOwnerDto;
import com.pelyshko.dto.assembler.CashWithdrawalFromServiceToOwnerDtoAssembler;
import com.pelyshko.service.CashWithdrawalFromServiceToOwnerService;


@RestController
@RequestMapping(value = "/api/CashWithdrawalsFromServiceToOwner")
public class CashWithdrawalFromServiceToOwnerController {
	@Autowired
    private CashWithdrawalFromServiceToOwnerService cashServiceOwnerService;
    @Autowired
    private CashWithdrawalFromServiceToOwnerDtoAssembler cashServiceOwnerDtoAssembler;

    @GetMapping(value = "/{cashServiceOwnerId}")
    public ResponseEntity<CashWithdrawalFromServiceToOwnerDto> getCashWithdrawalFromServiceToOwner(@PathVariable Integer cashServiceOwnerId) {
    	CashWithdrawalFromServiceToOwner cashServiceOwner = cashServiceOwnerService.findById(cashServiceOwnerId);
    	CashWithdrawalFromServiceToOwnerDto cashServiceOwnerDto = cashServiceOwnerDtoAssembler.toModel(cashServiceOwner);
        return new ResponseEntity<>(cashServiceOwnerDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<CashWithdrawalFromServiceToOwnerDto>> getAllCashWithdrawalsFromServiceToOwner() {
        List<CashWithdrawalFromServiceToOwner> cashesServiceOwner = cashServiceOwnerService.findAll();
        CollectionModel<CashWithdrawalFromServiceToOwnerDto> cashServiceOwnerDtos = cashServiceOwnerDtoAssembler
        		.toCollectionModel(cashesServiceOwner);
        return new ResponseEntity<>(cashServiceOwnerDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<CashWithdrawalFromServiceToOwnerDto> addCashWithdrawalFromServiceToOwner
    (@RequestBody CashWithdrawalFromServiceToOwner cashServiceOwner) {
    	CashWithdrawalFromServiceToOwner newCashServiceOwner = cashServiceOwnerService.create(cashServiceOwner);
    	CashWithdrawalFromServiceToOwnerDto cashServiceOwnerDto = cashServiceOwnerDtoAssembler.toModel(newCashServiceOwner);
        return new ResponseEntity<>(cashServiceOwnerDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{cashServiceOwnerId}")
    public ResponseEntity<?> updateCashWithdrawalFromServiceToOwner
    (@RequestBody CashWithdrawalFromServiceToOwner updCashServiceOwner, @PathVariable Integer cashServiceOwnerId) {
    	cashServiceOwnerService.update(cashServiceOwnerId, updCashServiceOwner);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{cashServiceOwnerId}")
    public ResponseEntity<?> deleteCashWithdrawalFromServiceToOwner(@PathVariable Integer cashServiceOwnerId) {
    	cashServiceOwnerService.delete(cashServiceOwnerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
