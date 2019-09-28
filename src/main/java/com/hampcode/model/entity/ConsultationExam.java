package com.hampcode.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(ConsultationExamPK.class)
@Table(name = "consultation_exams")
public class ConsultationExam {

	@Id
	private MedicalExam medicalExam;

	@Id
	private MedicalConsultation medicalConsultation;

	public MedicalExam getMedicalExam() {
		return medicalExam;
	}

	public void setMedicalExam(MedicalExam medicalExam) {
		this.medicalExam = medicalExam;
	}

	public MedicalConsultation getMedicalConsultation() {
		return medicalConsultation;
	}

	public void setMedicalConsultation(MedicalConsultation medicalConsultation) {
		this.medicalConsultation = medicalConsultation;
	}

}
