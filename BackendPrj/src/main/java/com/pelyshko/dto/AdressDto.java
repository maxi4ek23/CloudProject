
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
@Relation(itemRelation = "adress", collectionRelation = "adresses")
public class AdressDto extends RepresentationModel<AdressDto> {
	private final Integer id;
	private final String street;
	private final Integer houseNumber;
	private final Integer cityId;
}
