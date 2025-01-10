package com.jpacourse.dto;
import com.jpacourse.persistence.enums.TreatmentType;
import java.time.LocalDateTime;
import java.util.List;

public class VisitTO {
    private Long id;
    private String description;
    private LocalDateTime time;
    private String doctorFullName;
    private List<TreatmentType> medicalTreatmentTypes;

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
    public String getDoctorFullName() {
        return doctorFullName;
    }
    public void setDoctorFullName(String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }
    public List<TreatmentType> getMedicalTreatmentTypes() {
        return medicalTreatmentTypes;
    }
    public void setMedicalTreatmentTypes(List<TreatmentType> medicalTreatmentTypes) {
        this.medicalTreatmentTypes = medicalTreatmentTypes;
    }
}