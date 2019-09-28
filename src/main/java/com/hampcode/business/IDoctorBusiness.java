package com.hampcode.business;

import java.util.List;
import java.util.Optional;

import com.hampcode.model.entity.Doctor;

public interface IDoctorBusiness extends IBusiness<Doctor> {
	List<Doctor> findDoctorByName(String name) throws Exception ;
	
	Optional<Doctor> findDoctorByDni(String dni)throws Exception ;

}