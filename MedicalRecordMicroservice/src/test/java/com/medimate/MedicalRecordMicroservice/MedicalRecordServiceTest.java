package com.medimate.MedicalRecordMicroservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medimate.MedicalRecordMicroservice.controllers.MedicalRecordController;
import com.medimate.MedicalRecordMicroservice.models.MedicalRecord;
import com.medimate.MedicalRecordMicroservice.repositories.MedicalRecordRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("Test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class MedicalRecordServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private MedicalRecord medicalRecord;

    @BeforeAll
    void setup() {
        medicalRecord = new MedicalRecord("Opis nalaza", 5, 1, 52);
        medicalRecord.setId(1);
    }

    @Test
    void getMedicalRecordsSuccessfully() throws Exception {
        mockMvc.perform(get(String.format("/medical-record/%d", 1))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(status().isOk());
    }

    @Test
    void addMedicalRecordsSuccessfully() throws Exception {
        mockMvc.perform(post("/medical-record").content(objectMapper.writeValueAsString(medicalRecord))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
