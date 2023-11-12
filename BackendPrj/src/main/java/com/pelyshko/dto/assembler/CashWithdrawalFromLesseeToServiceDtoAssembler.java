package com.pelyshko.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.pelyshko.controller.CashWithdrawalFromLesseeToServiceController;
import com.pelyshko.domain.CashWithdrawalFromLesseeToService;
import com.pelyshko.dto.CashWithdrawalFromLesseeToServiceDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CashWithdrawalFromLesseeToServiceDtoAssembler implements RepresentationModelAssembler<CashWithdrawalFromLesseeToService,
                                                                          CashWithdrawalFromLesseeToServiceDto> {
	@Override
    public CashWithdrawalFromLesseeToServiceDto toModel(CashWithdrawalFromLesseeToService entity) {
		CashWithdrawalFromLesseeToServiceDto cashWithdrawalFromLesseeToServiceDto = CashWithdrawalFromLesseeToServiceDto.builder()
                .id(entity.getId())
                .price(entity.getPrice())
                .reservationId(entity.getReservation().getId())
                .build();
        Link selfLink = linkTo(methodOn(CashWithdrawalFromLesseeToServiceController.class)
        		.getCashWithdrawalFromLesseeToService(cashWithdrawalFromLesseeToServiceDto.getId())).withSelfRel();
        cashWithdrawalFromLesseeToServiceDto.add(selfLink);
        return cashWithdrawalFromLesseeToServiceDto;
    }
	
	@Override
    public CollectionModel<CashWithdrawalFromLesseeToServiceDto> toCollectionModel(Iterable<? extends CashWithdrawalFromLesseeToService> entities) {
        CollectionModel<CashWithdrawalFromLesseeToServiceDto> cashWithdrawalFromLesseeToServiceDtos 
        = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(CashWithdrawalFromLesseeToServiceController.class)
        		.getAllCashWithdrawalsFromLesseeToService()).withSelfRel();
        cashWithdrawalFromLesseeToServiceDtos.add(selfLink);
        return cashWithdrawalFromLesseeToServiceDtos;
    }

    public CollectionModel<CashWithdrawalFromLesseeToServiceDto> toCollectionModel(Iterable<? extends CashWithdrawalFromLesseeToService> entities,
    		Link link) {
        CollectionModel<CashWithdrawalFromLesseeToServiceDto> cashWithdrawalFromLesseeToServiceDtos 
        = RepresentationModelAssembler.super.toCollectionModel(entities);
        cashWithdrawalFromLesseeToServiceDtos.add(link);
        return cashWithdrawalFromLesseeToServiceDtos;
    }
}
