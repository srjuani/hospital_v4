package com.hampcode.business.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.business.IMedicalConsultationBusiness;
import com.hampcode.dto.MedicalConsultationExamsDto;
import com.hampcode.model.entity.MedicalConsultation;
import com.hampcode.model.repository.IConsultationExamRepository;
import com.hampcode.model.repository.IMedicalConsultationRepository;

@Named
public class MedicalConsultationBusiness implements IMedicalConsultationBusiness, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IMedicalConsultationRepository medicalConsultationRepository;

	@Inject
	private IConsultationExamRepository consultationExamenRepository;

	@Override
	public Long insert(MedicalConsultation entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long update(MedicalConsultation entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicalConsultation> getAll() throws Exception {
		return medicalConsultationRepository.findAll();
	}

	@Override
	public Optional<MedicalConsultation> getOne(MedicalConsultation entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public MedicalConsultation saveMedicalConsultation(MedicalConsultationExamsDto mcDto) throws Exception {
		mcDto.getMedicalConsultation().getMedicalConsultationItems()
				.forEach(item -> item.setMedicalConsultation(mcDto.getMedicalConsultation()));

		medicalConsultationRepository.insert(mcDto.getMedicalConsultation());

		mcDto.getMedicalExams().forEach(exam -> {
			try {
				consultationExamenRepository.insert(mcDto.getMedicalConsultation().getId(),
						exam.getId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		return mcDto.getMedicalConsultation();
	}

}
