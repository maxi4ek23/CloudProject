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

import com.pelyshko.domain.CashWithdrawalFromLesseeToService;
import com.pelyshko.dto.CashWithdrawalFromLesseeToServiceDto;
import com.pelyshko.dto.assembler.CashWithdrawalFromLesseeToServiceDtoAssembler;
import com.pelyshko.service.CashWithdrawalFromLesseeToServiceService;


@RestController
@RequestMapping(value = "/api/cashWithdrawalsFromLesseeToService")
public class CashWithdrawalFromLesseeToServiceController {
	@Autowired
    private CashWithdrawalFromLesseeToServiceService cashLesseeServiceService;
    @Autowired
    private CashWithdrawalFromLesseeToServiceDtoAssembler cashLesseeServiceDtoAssembler;

    @GetMapping(value = "/{cashLesseeServiceId}")
    public ResponseEntity<CashWithdrawalFromLesseeToServiceDto> getCashWithdrawalFromLesseeToService(@PathVariable Integer cashLesseeServiceId) {
    	CashWithdrawalFromLesseeToService cashLesseeService = cashLesseeServiceService.findById(cashLesseeServiceId);
    	CashWithdrawalFromLesseeToServiceDto cashLesseeServiceDto = cashLesseeServiceDtoAssembler.toModel(cashLesseeService);
        return new ResponseEntity<>(cashLesseeServiceDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<CashWithdrawalFromLesseeToServiceDto>> getAllCashWithdrawalsFromLesseeToService() {
        List<CashWithdrawalFromLesseeToService> cashesLesseeService = cashLesseeServiceService.findAll();
        CollectionModel<CashWithdrawalFromLesseeToServiceDto> cashLesseeServiceDtos = cashLesseeServiceDtoAssembler
        		.toCollectionModel(cashesLesseeService);
        return new ResponseEntity<>(cashLesseeServiceDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<CashWithdrawalFromLesseeToServiceDto> addCashWithdrawalFromLesseeToService
    (@RequestBody CashWithdrawalFromLesseeToService cashLesseeService) {
    	CashWithdrawalFromLesseeToService newCashLesseeService = cashLesseeServiceService.create(cashLesseeService);
    	CashWithdrawalFromLesseeToServiceDto cashLesseeServiceDto = cashLesseeServiceDtoAssembler.toModel(newCashLesseeService);
        return new ResponseEntity<>(cashLesseeServiceDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{cashLesseeServiceId}")
    public ResponseEntity<?> updateCashWithdrawalFromLesseeToService
    (@RequestBody CashWithdrawalFromLesseeToService updCashLesseeService, @PathVariable Integer cashLesseeServiceId) {
    	cashLesseeServiceService.update(cashLesseeServiceId, updCashLesseeService);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{cashLesseeServiceId}")
    public ResponseEntity<?> deleteCashWithdrawalFromLesseeToService(@PathVariable Integer cashLesseeServiceId) {
    	cashLesseeServiceService.delete(cashLesseeServiceId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
