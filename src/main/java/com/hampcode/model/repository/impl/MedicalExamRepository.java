package com.hampcode.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.MedicalExam;
import com.hampcode.model.repository.IMedicalExamRepository;

@Named
public class MedicalExamRepository implements IMedicalExamRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "tallerPU")
	private EntityManager em;

	@Override
	public Long insert(MedicalExam entity) throws Exception {
		return null;
	}

	@Override
	public Long update(MedicalExam entity) throws Exception {
		return null;
	}

	@Override
	public List<MedicalExam> findAll() throws Exception {
		List<MedicalExam> medicalExams = new ArrayList<>();

		TypedQuery<MedicalExam> query = em.createQuery("FROM MedicalExam me", MedicalExam.class);
		medicalExams = query.getResultList();

		return medicalExams;
	}

	@Override
	public Optional<MedicalExam> findById(MedicalExam entity) throws Exception {

		return null;
	}

}
