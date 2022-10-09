package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.VaccinationCenter;
import com.example.model.ResponseData;
import com.example.service.VaccinationCenterService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/vaccinationCenter")
@Slf4j
public class VaccinationCenterController {

	@Autowired
	private VaccinationCenterService centerService;
	
	@PostMapping("/save")
	public VaccinationCenter saveVaccinationCenterDetails(@RequestBody VaccinationCenter center) {
		log.info("Inside Save Citizen of Controller");
		return centerService.saveCenterDetails(center);
	}

	@GetMapping("/{id}")
	public ResponseData getAllDataBasedOnCenterId(@PathVariable("id") int id) {
		ResponseData dataList = centerService.getAllDataBasedOnCenterId(id);
		return dataList;
	}

}