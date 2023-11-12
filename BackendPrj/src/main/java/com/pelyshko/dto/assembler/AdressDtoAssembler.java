package com.pelyshko.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.pelyshko.controller.AdressController;
import com.pelyshko.domain.Adress;
import com.pelyshko.dto.AdressDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AdressDtoAssembler implements RepresentationModelAssembler<Adress, AdressDto> {
	@Override
    public AdressDto toModel(Adress entity) {
		AdressDto adressDto = AdressDto.builder()
                .id(entity.getId())
                .street(entity.getStreet())
                .houseNumber(entity.getHouseNumber())
                .cityId(entity.getCity().getId())
                .build();
        Link selfLink = linkTo(methodOn(AdressController.class).getAdress(adressDto.getId())).withSelfRel();
        adressDto.add(selfLink);
        return adressDto;
    }
	
	@Override
    public CollectionModel<AdressDto> toCollectionModel(Iterable<? extends Adress> entities) {
        CollectionModel<AdressDto> adressDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(AdressController.class).getAllAdresses()).withSelfRel();
        adressDtos.add(selfLink);
        return adressDtos;
    }

    public CollectionModel<AdressDto> toCollectionModel(Iterable<? extends Adress> entities, Link link) {
        CollectionModel<AdressDto> adressDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        adressDtos.add(link);
        return adressDtos;
    }
}
