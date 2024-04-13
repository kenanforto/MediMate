package com.medimate.MedicalRecordMicroservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medimate.MedicalRecordMicroservice.enums.Gender;
import com.medimate.MedicalRecordMicroservice.models.Doctor;
import com.medimate.MedicalRecordMicroservice.models.MedicalRecord;
import com.medimate.MedicalRecordMicroservice.models.Patient;
import com.medimate.MedicalRecordMicroservice.repositories.MedicalRecordRepository;
import com.medimate.MedicalRecordMicroservice.services.MedicalRecordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

@AutoConfigureMockMvc
@SpringBootTest
public class MedicalRecordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    @MockBean
    private MedicalRecordRepository medicalRecordRepository;

    @Autowired
    @MockBean MedicalRecordService medicalRecordService;

    private static MedicalRecord medicalRecord;
    @BeforeEach
    void setup() {
        objectMapper.findAndRegisterModules();
        medicalRecord = new MedicalRecord("Opis nalaza", 5, 1, 52);
        medicalRecord.setId(1);
        medicalRecord.setPatientId(2);
        Patient patient = new Patient(
                "Patient name", "Patient lastName", LocalDate.of(1999, 5, 25), Gender.Female, "Address 123", "061111222"
        );
        patient.setId(2);

        Doctor doctor = new Doctor(
                "Doctor name", "Doctor lastName", "Cardiologist"
        );
        doctor.setId(1);

        when(medicalRecordRepository.findByPatientId(patient.getId())).thenReturn(List.of(medicalRecord));
        when(medicalRecordRepository.findByDoctorId(doctor.getId())).thenReturn(List.of(medicalRecord));
    }

    @Test
    void getAllMedicalRecords() throws Exception{
        this.mockMvc
                .perform(get("/medical-record/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void MedicalRecordNotFound() throws Exception {
        this.mockMvc
                .perform(get("/medical-recod/"+0))
                .andExpect(status().isNotFound());
    }

    @Test
    void getMedicalRecordsForPatient() throws Exception {
        this.mockMvc.perform(get("/medical-record/patient/"+2))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void getMedicalRecordsForDoctor() throws Exception {
        this.mockMvc.perform(get("/medical-record/doctor/"+1))
                .andDo(print())
                .andExpect(status().isOk());

    }
}
