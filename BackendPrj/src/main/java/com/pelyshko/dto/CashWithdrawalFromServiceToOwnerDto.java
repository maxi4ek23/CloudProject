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
@Relation(itemRelation = "cashWithdrawalFromServiceToOwner", collectionRelation = "cashWithdrawalFromServiceToOwners")
public class CashWithdrawalFromServiceToOwnerDto extends RepresentationModel<CashWithdrawalFromServiceToOwnerDto> {
	private final Integer id;
	private final Integer price;
	private final Integer cashWithdrawalFromLesseeToServiceId;
}
