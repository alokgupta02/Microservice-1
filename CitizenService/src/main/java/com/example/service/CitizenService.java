package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CitizenRepository;
import com.example.entity.Citizen;

@Service
public class CitizenService {
	
	@Autowired
	private CitizenRepository citizenRepository;
	
	public List<Citizen> findByVaccinationCenterId(int id){
		return citizenRepository.findByVaccinationCenterId(id);
	}

	public Citizen saveCitizen(Citizen citizen) {
		return citizenRepository.save(citizen);
	}

}