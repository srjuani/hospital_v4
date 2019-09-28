package com.hampcode.business.impl;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.business.IDoctorBusiness;
import com.hampcode.model.entity.Doctor;
import com.hampcode.model.repository.IDoctorRepository;


@Named
public class DoctorBusiness implements IDoctorBusiness,Serializable {


	private static final long serialVersionUID = 1L;
	@Inject
	private IDoctorRepository doctorRepository;

	@Transactional
	@Override
	public Long insert(Doctor entity) throws Exception {
		return doctorRepository.insert(entity);
	}

	@Transactional
	@Override
	public Long update(Doctor entity) throws Exception {
		return doctorRepository.update(entity);
	}


	@Override
	public List<Doctor> getAll() throws Exception {
		return doctorRepository.findAll();
	}

	@Override
	public Optional<Doctor> getOne(Doctor entity) throws Exception {
		return doctorRepository.findById(entity);
	}

	@Override
	public List<Doctor> findDoctorByName(String name) throws Exception {
		return doctorRepository.findByName(name);
	}

	@Override
	public Optional<Doctor> findDoctorByDni(String dni) throws Exception {
		return doctorRepository.findByDni(dni);
	}
}
