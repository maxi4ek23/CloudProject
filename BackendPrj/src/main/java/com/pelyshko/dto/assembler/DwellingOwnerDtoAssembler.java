package com.pelyshko.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.pelyshko.controller.DwellingOwnerController;


import com.pelyshko.domain.DwellingOwner;

import com.pelyshko.dto.DwellingOwnerDto;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DwellingOwnerDtoAssembler implements RepresentationModelAssembler<DwellingOwner, DwellingOwnerDto> {
	@Override
    public DwellingOwnerDto toModel(DwellingOwner entity) {
		DwellingOwnerDto dwellingOwnerDto = DwellingOwnerDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .phone(entity.getPlatformUser().getPhone())
                .email(entity.getPlatformUser().getEmail())
                .build();
        Link selfLink = linkTo(methodOn(DwellingOwnerController.class).getDwellingOwner(dwellingOwnerDto.getId())).withSelfRel();
        dwellingOwnerDto.add(selfLink);
        return dwellingOwnerDto;
    }
	
	@Override
    public CollectionModel<DwellingOwnerDto> toCollectionModel(Iterable<? extends DwellingOwner> entities) {
        CollectionModel<DwellingOwnerDto> dwellingOwnerDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(DwellingOwnerController.class).getAllDwellingOwners()).withSelfRel();
        dwellingOwnerDtos.add(selfLink);
        return dwellingOwnerDtos;
    }

    public CollectionModel<DwellingOwnerDto> toCollectionModel(Iterable<? extends DwellingOwner> entities, Link link) {
        CollectionModel<DwellingOwnerDto> dwellingOwnerDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        dwellingOwnerDtos.add(link);
        return dwellingOwnerDtos;
    }
}
