package com.pelyshko.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.pelyshko.controller.ReservationController;
import com.pelyshko.domain.Reservation;
import com.pelyshko.dto.ReservationDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ReservationDtoAssembler implements RepresentationModelAssembler<Reservation, ReservationDto> {
	@Override
    public ReservationDto toModel(Reservation entity) {
		ReservationDto reservationDto = ReservationDto.builder()
                .id(entity.getId())
                .isPossible(entity.getIsPossible())
                .name(entity.getName())
                .time(entity.getTime())
                .howLong(entity.getHowLong())
                .isConfirmed(entity.getIsConfirmed())
                .lesseeId(entity.getLessee().getId())
                .build();
        Link selfLink = linkTo(methodOn(ReservationController.class).getReservation(reservationDto.getId())).withSelfRel();
        reservationDto.add(selfLink);
        return reservationDto;
    }
	
	@Override
    public CollectionModel<ReservationDto> toCollectionModel(Iterable<? extends Reservation> entities) {
        CollectionModel<ReservationDto> reservationDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ReservationController.class).getAllReservations()).withSelfRel();
        reservationDtos.add(selfLink);
        return reservationDtos;
    }

    public CollectionModel<ReservationDto> toCollectionModel(Iterable<? extends Reservation> entities, Link link) {
        CollectionModel<ReservationDto> reservationDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        reservationDtos.add(link);
        return reservationDtos;
    }
}
