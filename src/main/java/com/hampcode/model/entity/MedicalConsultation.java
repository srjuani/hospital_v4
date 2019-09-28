package com.hampcode.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "medical_consultations")
public class MedicalConsultation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String patient;

	private Date consultationDate;

	@OneToMany(mappedBy="medicalConsultation",
			cascade= {
					  CascadeType.PERSIST,
					  CascadeType.MERGE,
					  CascadeType.REMOVE
					  },
			fetch=FetchType.LAZY)
	private List<MedicalConsultationItem> medicalConsultationItems;

	
	@PrePersist 
	public void init() {
		consultationDate=new Date();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public Date getConsultationDate() {
		return consultationDate;
	}

	public void setConsultationDate(Date consultationDate) {
		this.consultationDate = consultationDate;
	}

	public List<MedicalConsultationItem> getMedicalConsultationItems() {
		return medicalConsultationItems;
	}

	public void setMedicalConsultationItems(List<MedicalConsultationItem> medicalConsultationItems) {
		this.medicalConsultationItems = medicalConsultationItems;
	}

}
