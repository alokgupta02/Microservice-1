package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Citizen;
import com.example.service.CitizenService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/citizen")
@Slf4j
public class CitizenController {

	@Autowired
	private CitizenService service;
	
	@PostMapping("/save")
	public Citizen saveCitizen(@RequestBody Citizen citizen) {
		log.info("Inside Save Citizen of Controller");
		return service.saveCitizen(citizen);
	}

	@GetMapping("/{id}")
	public List<Citizen> getById(@PathVariable("id") int id) {
		List<Citizen> citizenList = service.findByVaccinationCenterId(id);
		return citizenList;

	}

}
