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
@Relation(itemRelation = "reservation", collectionRelation = "reservations")
public class ReservationDto extends RepresentationModel<ReservationDto> {
	private final Integer id;
	private final Boolean isPossible;
	private final String name;
	private final String time;
	private final String howLong;
	private final Boolean isConfirmed;
	private final Integer lesseeId;
}
