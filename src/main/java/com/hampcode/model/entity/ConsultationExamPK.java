package com.hampcode.model.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ConsultationExamPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "medical_consultation_id", nullable = false)
	private MedicalConsultation medicalConsultation;

	@ManyToOne
	@JoinColumn(name = "medical_exam_id", nullable = false)
	private MedicalExam medicalExam;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((medicalConsultation == null) ? 0 : medicalConsultation.hashCode());
		result = prime * result + ((medicalExam == null) ? 0 : medicalExam.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultationExamPK other = (ConsultationExamPK) obj;
		if (medicalConsultation == null) {
			if (other.medicalConsultation != null)
				return false;
		} else if (!medicalConsultation.equals(other.medicalConsultation))
			return false;
		if (medicalExam == null) {
			if (other.medicalExam != null)
				return false;
		} else if (!medicalExam.equals(other.medicalExam))
			return false;
		return true;
	}

}
