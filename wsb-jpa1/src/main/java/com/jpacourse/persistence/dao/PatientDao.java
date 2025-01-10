package com.jpacourse.persistence.dao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import java.time.LocalDateTime;
import java.util.List;


public interface PatientDao extends Dao<PatientEntity, Long> {

    VisitEntity addNewVisit(Long patientId, Long doctorId, LocalDateTime date, String visitDescription);

    List<VisitEntity> findVisitsByPatientId(Long patientId);

}