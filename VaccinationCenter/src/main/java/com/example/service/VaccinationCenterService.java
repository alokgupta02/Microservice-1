package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dao.VaccinationCenterRepository;
import com.example.entity.VaccinationCenter;
import com.example.model.Citizen;
import com.example.model.ResponseData;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class VaccinationCenterService {

	@Autowired
	private VaccinationCenterRepository centerRepository;

	@Autowired
	private RestTemplate restTemplate;

	public VaccinationCenter saveCenterDetails(VaccinationCenter details) {
		return centerRepository.save(details);
	}

	@HystrixCommand(fallbackMethod = "handleCitizenDowntime")
	public ResponseData getAllDataBasedOnCenterId(int id) {
		ResponseData data = new ResponseData();
		VaccinationCenter vcDetails =  centerRepository.findById(id).get();
		List<Citizen>  citizensList = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/"+id, List.class);
		data.setCenter(vcDetails);
		data.setCitizens(citizensList);
		return data;
	}
	
	public ResponseData handleCitizenDowntime(int id) {
		ResponseData data = new ResponseData();
		VaccinationCenter vcDetails =  centerRepository.findById(id).get();
		data.setCenter(vcDetails);
		return data;
	}

}
