package com.hampcode.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import com.hampcode.model.entity.MedicalConsultation;
import com.hampcode.model.repository.IMedicalConsultationRepository;

@Named
public class MedicalConsultationRepository implements IMedicalConsultationRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "tallerPU")
	private EntityManager em;

	
	@Override
	public Long insert(MedicalConsultation entity) throws Exception {
		em.persist(entity);
		return entity.getId();
	}

	@Override
	public Long update(MedicalConsultation entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicalConsultation> findAll() throws Exception {
		List<MedicalConsultation> medicalConsultations = new ArrayList<>();

		TypedQuery<MedicalConsultation> query = em.createQuery("FROM MedicalConsultation mc", MedicalConsultation.class);
		medicalConsultations = query.getResultList();

		return medicalConsultations;
	}

	@Override
	public Optional<MedicalConsultation> findById(MedicalConsultation entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
