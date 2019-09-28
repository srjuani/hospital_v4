package com.hampcode.dto;

import java.util.List;

import com.hampcode.model.entity.MedicalConsultation;
import com.hampcode.model.entity.MedicalExam;

public class MedicalConsultationExamsDto {

	private MedicalConsultation medicalConsultation;

	private List<MedicalExam> medicalExams;

	public MedicalConsultation getMedicalConsultation() {
		return medicalConsultation;
	}

	public void setMedicalConsultation(MedicalConsultation medicalConsultation) {
		this.medicalConsultation = medicalConsultation;
	}

	public List<MedicalExam> getMedicalExams() {
		return medicalExams;
	}

	public void setMedicalExams(List<MedicalExam> medicalExams) {
		this.medicalExams = medicalExams;
	}

}
