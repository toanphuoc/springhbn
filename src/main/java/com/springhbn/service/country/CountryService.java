package com.springhbn.service.country;

import java.util.List;

import com.springhbn.model.Country;

public interface CountryService {

	public List<Country> getAllCountries();
	public Country getCountry(int id);
	public Country addCountry(Country country);
	public void updateCountry(Country country);
	public void deleteCountry(int id);
	public List<Country> findByPopulation(long population, int caseForSearch);
	public List<Country> findByExample(Country country);
	public List<Country> findByLike(Country country);
}
