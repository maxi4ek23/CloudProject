package com.pelyshko.dto;


import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "dwellingOwner", collectionRelation = "dwellingOwners")
public class DwellingOwnerDto extends RepresentationModel<DwellingOwnerDto> {
	private final Integer id;
	private final String name;
	private final String surname;
	private final String phone;
    private final String email;
}
