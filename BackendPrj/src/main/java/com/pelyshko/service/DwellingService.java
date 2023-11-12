package com.pelyshko.service;


import java.util.List;

import com.pelyshko.domain.Dwelling;

public interface DwellingService extends GeneralService<Dwelling, Integer> {
	List<Dwelling> findDwellingsByDwellingOwnerSurname(String dwellingOwnerSurname);
	void createManyToManyRelationship(Integer dwellId, Integer userId);
}
