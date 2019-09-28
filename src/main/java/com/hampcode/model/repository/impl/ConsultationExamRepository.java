package com.hampcode.model.repository.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hampcode.model.entity.ConsultationExam;
import com.hampcode.model.repository.IConsultationExamRepository;

@Named
public class ConsultationExamRepository implements IConsultationExamRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "tallerPU")
	private EntityManager em;

	@Override
	public Long insert(ConsultationExam entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long update(ConsultationExam entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConsultationExam> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ConsultationExam> findById(ConsultationExam entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long insert(Long medicalConsultationId, Long medicalExamId) throws Exception {
	     
		long result=em.createNativeQuery("INSERT INTO consultation_exams "
				+ "(medical_consultation_id, medical_exam_id) "
				+ "VALUES(?,?)")
				.setParameter(1, medicalConsultationId)
				.setParameter(2, medicalExamId)
				.executeUpdate();
		
		
		return result;
	}
	
	
	
	

}
