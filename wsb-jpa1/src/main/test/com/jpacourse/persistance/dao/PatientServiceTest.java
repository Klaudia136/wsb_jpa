package com.jpacourse.persistance.dao;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.service.impl.PatientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientDao patientDao;
    private PatientServiceImpl patientService;

    @BeforeEach
    public void setUp() {
        patientService = new PatientServiceImpl(patientDao);
    }

    @Test
    @Transactional
    public void testFindByIdShouldReturnPatientTO() {
        // given
        Long patientId = 1L;

        // when
        PatientTO result = patientService.findById(patientId);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(patientId);
        assertThat(result.getFirstName()).isEqualTo("Mickey");
        assertThat(result.getLastName()).isEqualTo("Mouse");
        assertThat(result.getHasBeenVaccinated()).isEqualTo(true);
        assertThat(result.getTelephoneNumber()).isEqualTo("989652454");
        assertThat(result.getEmail()).isEqualTo("mickeyy2@example.com");
        assertThat(result.getPatientNumber()).isEqualTo("P01");
        assertThat(result.getDateOfBirth()).isEqualTo(LocalDate.of(1928, 11, 18));

        assertThat(result.getVisits()).hasSize(2);

        System.out.println("\nPatientTO:\n");
        System.out.println("ID: " + result.getId());
        System.out.println("First Name: " + result.getFirstName() + "\n");
    }

    @Test
    @Transactional
    public void testFindByIdShouldReturnNullIfPatientNotFound() {
        Long patientId = 100L;
        PatientTO result = patientService.findById(patientId);
        assertThat(result).isNull();
    }

    @Test
    @Transactional
    public void testIfDeletingPatientEffectsVisits()
    {
        Long patientId = 1L;
        PatientTO result = patientService.findById(patientId);

        patientDao.delete(patientId);

        PatientTO afterDelete = patientService.findById(patientId);
        assertThat(afterDelete).isNull();
        assertThat(patientService.findVisitsByPatientId(patientId)).isEmpty();
    }
}