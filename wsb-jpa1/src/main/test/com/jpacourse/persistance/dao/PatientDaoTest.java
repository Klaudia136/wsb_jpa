package com.jpacourse.persistance.dao;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.VisitEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class PatientDaoTest {

        @Autowired
        private PatientDao patientDao;
        @Test
        @Transactional

         public void testAddNewVisit() {
        // given
        Long patientId = 1L;
        Long doctorId = 1L;
        LocalDateTime date = LocalDateTime.of(2023, 5, 15, 7, 10);
        String visitDescription = "Czy zostala dodana";

        // when
        VisitEntity newVisit = patientDao.addNewVisit(patientId, doctorId, date, visitDescription);

        // then
        assertThat(newVisit).isNotNull();
        assertThat(newVisit.getDescription()).isEqualTo(visitDescription);
        assertThat(newVisit.getPatient().getId()).isEqualTo(patientId);
        assertThat(newVisit.getDoctor().getId()).isEqualTo(doctorId);
    }
}
