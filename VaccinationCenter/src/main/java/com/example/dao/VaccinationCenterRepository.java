package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.VaccinationCenter;

@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Integer>{

}