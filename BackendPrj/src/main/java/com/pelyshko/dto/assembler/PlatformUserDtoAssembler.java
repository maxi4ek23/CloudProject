package com.pelyshko.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.pelyshko.controller.PlatformUserController;
import com.pelyshko.domain.PlatformUser;
import com.pelyshko.dto.PlatformUserDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PlatformUserDtoAssembler implements RepresentationModelAssembler<PlatformUser, PlatformUserDto> {
	@Override
    public PlatformUserDto toModel(PlatformUser entity) {
		PlatformUserDto platformUserDto = PlatformUserDto.builder()
                .id(entity.getId())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .build();
        Link selfLink = linkTo(methodOn(PlatformUserController.class).getPlatformUser(platformUserDto.getId())).withSelfRel();
        platformUserDto.add(selfLink);
        return platformUserDto;
    }
	
	@Override
    public CollectionModel<PlatformUserDto> toCollectionModel(Iterable<? extends PlatformUser> entities) {
        CollectionModel<PlatformUserDto> platformUserDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(PlatformUserController.class).getAllPlatformUsers()).withSelfRel();
        platformUserDtos.add(selfLink);
        return platformUserDtos;
    }

    public CollectionModel<PlatformUserDto> toCollectionModel(Iterable<? extends PlatformUser> entities, Link link) {
        CollectionModel<PlatformUserDto> platformUserDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        platformUserDtos.add(link);
        return platformUserDtos;
    }
}
