package com.example.world.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

import com.example.world.dao.CountryDao;
import com.example.world.entity.Country;

@Controller
@RequestMapping("list")
@RequestScope
public class WorldController {
	@Autowired private CountryDao countryDao;
	
	@ModelAttribute("continents") // ${continents}
	public Set<String> getAllContinents(){
		return countryDao.getAllContinents();
	}
	
	@GetMapping
	public String home() {
		return "home";
	}
	@PostMapping
	public String list(Model model,String continent) {
		List<Country> countries = 
				countryDao.findCountriesByContinent(
						continent);
		model.addAttribute("countries", countries);
		return "home";
	}
}
