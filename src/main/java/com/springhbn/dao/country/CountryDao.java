package com.springhbn.dao.country;

import java.util.List;

import com.springhbn.dao.GenericDAO;
import com.springhbn.model.Country;

public interface CountryDao extends GenericDAO<Country>{

	public List<Country> findByPopulation(long population, int caseForSearch);
}
