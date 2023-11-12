package com.pelyshko.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.pelyshko.controller.DwellingController;
import com.pelyshko.domain.Dwelling;
import com.pelyshko.dto.DwellingDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DwellingDtoAssembler implements RepresentationModelAssembler<Dwelling, DwellingDto> {
	@Override
    public DwellingDto toModel(Dwelling entity) {
		DwellingDto dwellingDto = DwellingDto.builder()
                .id(entity.getId())
                .area(entity.getArea())
                .floor(entity.getFloor())
                .roomsNumber(entity.getRoomsNumber())
                .description(entity.getDescription())
                .dwellingOwnerId(entity.getDwellingOwner().getId())
                .adressId(entity.getAdress().getId())
                .reservationId(entity.getReservation().getId())
                .build();
        Link selfLink = linkTo(methodOn(DwellingController.class).getDwelling(dwellingDto.getId())).withSelfRel();
        dwellingDto.add(selfLink);
        return dwellingDto;
    }
	
	@Override
    public CollectionModel<DwellingDto> toCollectionModel(Iterable<? extends Dwelling> entities) {
        CollectionModel<DwellingDto> dwellingDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(DwellingController.class).getAllDwellings()).withSelfRel();
        dwellingDtos.add(selfLink);
        return dwellingDtos;
    }

    public CollectionModel<DwellingDto> toCollectionModel(Iterable<? extends Dwelling> entities, Link link) {
        CollectionModel<DwellingDto> dwellingDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        dwellingDtos.add(link);
        return dwellingDtos;
    }
}
