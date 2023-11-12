package com.pelyshko.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.pelyshko.controller.CashWithdrawalFromServiceToOwnerController;
import com.pelyshko.domain.CashWithdrawalFromServiceToOwner;
import com.pelyshko.dto.CashWithdrawalFromServiceToOwnerDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CashWithdrawalFromServiceToOwnerDtoAssembler implements RepresentationModelAssembler<CashWithdrawalFromServiceToOwner,
																	CashWithdrawalFromServiceToOwnerDto> {
	@Override
    public CashWithdrawalFromServiceToOwnerDto toModel(CashWithdrawalFromServiceToOwner entity) {
		CashWithdrawalFromServiceToOwnerDto сashWithdrawalFromServiceToOwnerDto = CashWithdrawalFromServiceToOwnerDto.builder()
                .id((entity).getId())
                .price(entity.getPrice())
                .cashWithdrawalFromLesseeToServiceId(entity.getCashWithdrawalFromLesseeToService().getId())
                .build();
        Link selfLink = linkTo(methodOn(CashWithdrawalFromServiceToOwnerController.class)
        		.getCashWithdrawalFromServiceToOwner(сashWithdrawalFromServiceToOwnerDto.getId())).withSelfRel();
        сashWithdrawalFromServiceToOwnerDto.add(selfLink);
        return сashWithdrawalFromServiceToOwnerDto;
    }
	
	@Override
    public CollectionModel<CashWithdrawalFromServiceToOwnerDto> toCollectionModel(Iterable<? extends CashWithdrawalFromServiceToOwner> entities) {
        CollectionModel<CashWithdrawalFromServiceToOwnerDto> сashWithdrawalFromServiceToOwnerDtos 
        = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(CashWithdrawalFromServiceToOwnerController.class)
        		.getAllCashWithdrawalsFromServiceToOwner()).withSelfRel();
        сashWithdrawalFromServiceToOwnerDtos.add(selfLink);
        return сashWithdrawalFromServiceToOwnerDtos;
    }

    public CollectionModel<CashWithdrawalFromServiceToOwnerDto> toCollectionModel(Iterable<? extends CashWithdrawalFromServiceToOwner> entities, Link link) {
        CollectionModel<CashWithdrawalFromServiceToOwnerDto> сashWithdrawalFromServiceToOwnerDtos 
        = RepresentationModelAssembler.super.toCollectionModel(entities);
        сashWithdrawalFromServiceToOwnerDtos.add(link);
        return сashWithdrawalFromServiceToOwnerDtos;
    }
}
