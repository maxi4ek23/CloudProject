package com.pelyshko.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.pelyshko.controller.LesseeController;
import com.pelyshko.domain.Lessee;
import com.pelyshko.dto.LesseeDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class LesseeDtoAssembler implements RepresentationModelAssembler<Lessee, LesseeDto> {
	@Override
    public LesseeDto toModel(Lessee entity) {
		LesseeDto lesseeDto = LesseeDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .phone(entity.getPlatformUser().getPhone())
                .email(entity.getPlatformUser().getEmail())
                .build();
        Link selfLink = linkTo(methodOn(LesseeController.class).getLessee(lesseeDto.getId())).withSelfRel();
        lesseeDto.add(selfLink);
        return lesseeDto;
    }
	
	@Override
    public CollectionModel<LesseeDto> toCollectionModel(Iterable<? extends Lessee> entities) {
        CollectionModel<LesseeDto> lesseeDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(LesseeController.class).getAllLessees()).withSelfRel();
        lesseeDtos.add(selfLink);
        return lesseeDtos;
    }

    public CollectionModel<LesseeDto> toCollectionModel(Iterable<? extends Lessee> entities, Link link) {
        CollectionModel<LesseeDto> lesseeDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        lesseeDtos.add(link);
        return lesseeDtos;
    }
}
