package com.hampcode.business;

import com.hampcode.dto.MedicalConsultationExamsDto;
import com.hampcode.model.entity.MedicalConsultation;

public interface IMedicalConsultationBusiness 
	extends IBusiness<MedicalConsultation>{

	MedicalConsultation saveMedicalConsultation(MedicalConsultationExamsDto mcDto)  throws Exception ;
}
