package com.medimate.WorkingHoursMicroservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medimate.WorkingHoursMicroservice.models.Admin;
import com.medimate.WorkingHoursMicroservice.models.Doctor;
import com.medimate.WorkingHoursMicroservice.models.TrackWorkingHours;
import com.medimate.WorkingHoursMicroservice.models.WorkingHours;
import com.medimate.WorkingHoursMicroservice.repositories.WorkingHoursRepository;
import com.medimate.WorkingHoursMicroservice.services.WorkingHoursService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalTime;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
public class WorkingHoursMicroserviceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    @MockBean
    private WorkingHoursRepository workingHoursRepository;

    @Autowired
    @MockBean
    private WorkingHoursService workingHoursService;

    private static WorkingHours workingHours;

    @BeforeEach
    void setup() {
        objectMapper.findAndRegisterModules();
        workingHours = new WorkingHours(LocalTime.of(1,0), LocalTime.of(8, 0), "cardiologist", 1, 1);
        workingHours.setId(1);

        Doctor doctor = new Doctor(
                "Doctor name", "Doctor lastName", "Cardiologist"
        );
        doctor.setId(1);

        TrackWorkingHours trackWorkingHours = new TrackWorkingHours(8, 1, 1);
        trackWorkingHours.setId(1);

        Admin admin = new Admin("admin", "admin");
        admin.setId(1);

        when(workingHoursRepository.findById(1)).thenReturn(Optional.of(workingHours));
    }

    @Test
    void WorkingHoursNotFound() throws Exception {
        this.mockMvc
                .perform(get("/working-hours/"+0))
                .andExpect(status().isNotFound());
    }

    @Test
    void getWorkingHoursById() throws Exception {
        this.mockMvc
                .perform(get("/working-hours/"+1))
                .andExpect(status().isOk());
    }
}
