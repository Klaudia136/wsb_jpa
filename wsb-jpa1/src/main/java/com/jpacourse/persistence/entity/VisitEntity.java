package com.jpacourse.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id")
	private DoctorEntity doctor;

	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_id") // relacja jednostronna
	private PatientEntity patient;

	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "medical_treatment_id") // relacja jednostronna
	private MedicalTreatmentEntity medicalTreatment;

	@OneToMany(mappedBy = "visit", cascade = CascadeType.ALL) // Relacja dwustronna z MedicalTreatment
	private List<MedicalTreatmentEntity> treatments;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}
	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}
	public PatientEntity getPatient() {
		return patient;
	}
	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}
	public List<MedicalTreatmentEntity> getTreatments() {
		return treatments;
	}
	public void setTreatments(List<MedicalTreatmentEntity> treatments) {
		this.treatments = treatments;
	}
}
