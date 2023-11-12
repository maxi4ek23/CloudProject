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
@Relation(itemRelation = "dwelling", collectionRelation = "dwellings")
public class DwellingDto extends RepresentationModel<DwellingDto> {
	private final Integer id;
	private final Integer area;
	private final Integer floor;
	private final Integer roomsNumber;
	private final String description;
	private final Integer dwellingOwnerId;
	private final Integer adressId;
	private final Integer reservationId;
}
