package com.springhbn.service.country.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springhbn.dao.country.CountryDao;
import com.springhbn.model.Country;
import com.springhbn.service.country.CountryService;

@Service("countryService")
public class CountryServiceImpl implements CountryService{

	@Autowired
	CountryDao countryDao;
	
	@Override
	@Transactional
	public List<Country> getAllCountries() {
		System.out.println("getAllCountries is calling");
		return countryDao.findAll();
	}

	@Override
	@Transactional
	public Country getCountry(int id) {
		System.out.println("getCountry is calling");
		return countryDao.findById(id);
	}
	
	@Override
	@Transactional
	public Country addCountry(Country country) {
		int id = (int) countryDao.save(country);
		return country = countryDao.findById(id);
	}

	@Override
	@Transactional
	public void updateCountry(Country country) {
		System.out.println("updateCountry is calling");
		countryDao.saveOrUpdate(country);

	}

	@Override
	@Transactional
	public void deleteCountry(int id) {
		System.out.println("deleteCountry is calling");
		countryDao.delete(id);
	}

	@Override
	@Transactional
	public List<Country> findByPopulation(long population, int caseForSearch) {
		return countryDao.findByPopulation(population, caseForSearch);
	}

	@Override
	@Transactional
	public List<Country> findByExample(Country country) {
		return countryDao.findByExample(country);
	}

	@Override
	@Transactional
	public List<Country> findByLike(Country country) {
		return countryDao.findByLike(country);
	}
}
