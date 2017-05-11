package com.springhbn.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springhbn.model.Country;
import com.springhbn.service.country.CountryService;

@Controller
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@RequestMapping(value = "/getAllCountries", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getCountries(Model model) {
		
		List<Country> listOfCountries = countryService.getAllCountries();
		model.addAttribute("country", new Country());
		model.addAttribute("listOfCountries", listOfCountries);
		return "countryDetails";
	}

	@RequestMapping(value = "/getCountry/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Country getCountryById(@PathVariable int id) {
		return countryService.getCountry(id);
	}

	@RequestMapping(value = "/addCountry", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public Country addCountry(@RequestBody Country country) {	
		return countryService.addCountry(country);
	}

	@RequestMapping(value = "/updateCountry/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateCountry(@PathVariable("id") int id,Model model) {
		 model.addAttribute("country", this.countryService.getCountry(id));
	        model.addAttribute("listOfCountries", this.countryService.getAllCountries());
	        return "countryDetails";
	}

	@RequestMapping(value = "/deleteCountry/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteCountry(@PathVariable("id") int id) {
		countryService.deleteCountry(id);
		 return "redirect:/getAllCountries";

	}	
	
	@RequestMapping(value = "/find", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<Country> findByPopulation(@RequestParam("p") long population, @RequestParam("c") int caseForSearch){
		return countryService.findByPopulation(population, caseForSearch);
	}
	
	@RequestMapping(value = "/findByExample", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public List<Country> findByExample(@RequestBody Country country){
		return countryService.findByExample(country);
	}
	
	@RequestMapping(value = "/findByLike", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public List<Country> findByLike(@RequestBody Country country){
		return countryService.findByLike(country);
	}
}
