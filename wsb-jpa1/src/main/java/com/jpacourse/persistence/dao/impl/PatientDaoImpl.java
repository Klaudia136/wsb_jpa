package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    public VisitEntity addNewVisit(Long patientId, Long doctorId, LocalDateTime date, String visitDescription) {
        PatientEntity patientEntity = entityManager.find(PatientEntity.class, patientId);
        DoctorEntity doctorEntity = entityManager.find(DoctorEntity.class, doctorId);

        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setTime(date);
        visitEntity.setDescription(visitDescription);
        visitEntity.setDoctor(doctorEntity);
        visitEntity.setPatient(patientEntity);

        patientEntity.getVisits().add(visitEntity);

        update(patientEntity);

        return visitEntity;
    }

    @Override
    public List<VisitEntity> findVisitsByPatientId(Long patient_Id) {
        return entityManager.createQuery("SELECT v FROM VisitEntity v " +
                        "JOIN FETCH v.patient p " +
                        "WHERE p.id = :patientId", VisitEntity.class)
                .setParameter("patientId", patient_Id)
                .getResultList();
    }

}