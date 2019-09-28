package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hampcode.business.IMedicaExamBusiness;
import com.hampcode.business.impl.MedicalConsultationBusiness;
import com.hampcode.dto.MedicalConsultationExamsDto;
import com.hampcode.model.entity.MedicalConsultation;
import com.hampcode.model.entity.MedicalConsultationItem;
import com.hampcode.model.entity.MedicalExam;
import com.hampcode.util.Message;

@Named
@ViewScoped
public class MedicalConsultationController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IMedicaExamBusiness medicalExamBusiness;
	
	@Inject
	private MedicalConsultationBusiness medicalConsutationBusiness;

	// Medical Consultation
	private MedicalConsultation medicalConsultation;
	private List<MedicalConsultation> medicalConsultations;

	// Medical Consultation Items
	private MedicalConsultationItem medicalConsultationItem;
	private List<MedicalConsultationItem> medicalConsultationItems;

	// Medical Exams
	private MedicalExam medicalExam;
	private List<MedicalExam> medicalExams;
	private List<MedicalExam> medicalExamItems;

	// MedicalConsultationExamDto
	private MedicalConsultationExamsDto medicalConsultationExamDto;
	

	@PostConstruct
	public void init() {
		medicalConsultationExamDto = new MedicalConsultationExamsDto();
		
		medicalConsultation = new MedicalConsultation();
		medicalConsultations = new ArrayList<>();
		
		medicalConsultationItem = new MedicalConsultationItem();
		medicalConsultationItems = new ArrayList<>();

		medicalExam = new MedicalExam();
		medicalExams = new ArrayList<MedicalExam>();
		medicalExamItems = new ArrayList<>();

		getAllExams();
		gelAllMedicalConsultation();
	}

	public void getAllExams() {
		try {
			medicalExams = medicalExamBusiness.getAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void gelAllMedicalConsultation() {
		try {
			medicalConsultations = medicalConsutationBusiness.getAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void saveMedicalConsultation() {
		try {
			if (!medicalConsultationItems.isEmpty()) {

				medicalConsultation.setMedicalConsultationItems(medicalConsultationItems);

				medicalConsultationExamDto.setMedicalConsultation(medicalConsultation);
				medicalConsultationExamDto.setMedicalExams(medicalExamItems);

				medicalConsutationBusiness.saveMedicalConsultation(medicalConsultationExamDto);

				resetForm();
				cleanMedicalConsultationItem();
				cleanMedicalExamenItem();

				Message.messageInfo("Consulta Registrada");

			} else {
				resetForm();
				Message.messageInfo("Tienen que ingresar tratamientos y diagnosticos");
			}
		} catch (Exception e) {
			resetForm();
			Message.messageError("Error Consulta Registrada:" + e.getStackTrace());
			System.out.println("Error Consulta :" + e.getCause());
		}
	}

	public void resetForm() {
		medicalConsultation = new MedicalConsultation();
		medicalConsultationItems.clear();
		medicalExamItems.clear();

	}

	public void addMedicalConsultationItem() {
		if (!medicalConsultationItem.getDiagnostic().isEmpty() && !medicalConsultationItem.getTreatment().isEmpty()) {
			medicalConsultationItems.add(medicalConsultationItem);
			cleanMedicalConsultationItem();
		} else {
			Message.messageInfo("Debe ingresar un diagnostico y tratamiento");
		}
	}

	public void addMedicalExamenItem() {

		medicalExamItems.add(medicalExam);
	}

	public void cleanMedicalConsultationItem() {
		medicalConsultationItem = new MedicalConsultationItem();
	}

	public void cleanMedicalExamenItem() {
		medicalExam = new MedicalExam();
	}

	public MedicalConsultation getMedicalConsultation() {
		return medicalConsultation;
	}

	public void setMedicalConsultation(MedicalConsultation medicalConsultation) {
		this.medicalConsultation = medicalConsultation;
	}

	public MedicalConsultationItem getMedicalConsultationItem() {
		return medicalConsultationItem;
	}

	public void setMedicalConsultationItem(MedicalConsultationItem medicalConsultationItem) {
		this.medicalConsultationItem = medicalConsultationItem;
	}

	public List<MedicalConsultationItem> getMedicalConsultationItems() {
		return medicalConsultationItems;
	}

	public void setMedicalConsultationItems(List<MedicalConsultationItem> medicalConsultationItems) {
		this.medicalConsultationItems = medicalConsultationItems;
	}

	public MedicalExam getMedicalExam() {
		return medicalExam;
	}

	public void setMedicalExam(MedicalExam medicalExam) {
		this.medicalExam = medicalExam;
	}

	public List<MedicalExam> getMedicalExams() {
		return medicalExams;
	}

	public void setMedicalExams(List<MedicalExam> medicalExams) {
		this.medicalExams = medicalExams;
	}

	public List<MedicalExam> getMedicalExamItems() {
		return medicalExamItems;
	}

	public void setMedicalExamItems(List<MedicalExam> medicalExamItems) {
		this.medicalExamItems = medicalExamItems;
	}

	public List<MedicalConsultation> getMedicalConsultations() {
		return medicalConsultations;
	}

	public void setMedicalConsultations(List<MedicalConsultation> medicalConsultations) {
		this.medicalConsultations = medicalConsultations;
	}

	public MedicalConsultationExamsDto getMedicalConsultationExamDto() {
		return medicalConsultationExamDto;
	}

	public void setMedicalConsultationExamDto(MedicalConsultationExamsDto medicalConsultationExamDto) {
		this.medicalConsultationExamDto = medicalConsultationExamDto;
	}

	
	
}
