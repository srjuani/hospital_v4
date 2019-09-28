package com.hampcode.model.repository;

import com.hampcode.model.entity.ConsultationExam;

public interface IConsultationExamRepository 
   extends IRepository<ConsultationExam>{
	
	Long insert(Long medicalConsultationId, Long medicalExamId)throws Exception;

}
