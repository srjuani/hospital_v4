package com.hampcode.business.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import com.hampcode.business.IMedicaExamBusiness;
import com.hampcode.model.entity.MedicalExam;
import com.hampcode.model.repository.IMedicalExamRepository;

@Named
public class MedicalExamBusiness implements IMedicaExamBusiness, Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IMedicalExamRepository medicalRepository;

	@Override
	public Long insert(MedicalExam entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long update(MedicalExam entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicalExam> getAll() throws Exception {
		return medicalRepository.findAll();
	}

	@Override
	public Optional<MedicalExam> getOne(MedicalExam entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
