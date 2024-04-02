package com.medimate.SuppliesMicroservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medimate.SuppliesMicroservice.models.Supplies;
import com.medimate.SuppliesMicroservice.repositories.SuppliesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("Test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class SuppliesServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SuppliesRepository suppliesRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Supplies supplies;

    @BeforeAll
    void setup() {
        supplies = new Supplies();
        supplies.setId(3);
        supplies.setAmount(3);
    }

    @Test
    void getSuppliesSuccessfully() throws Exception {
        mockMvc.perform(get(String.format("/supplies/%d", 3))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(status().isOk());
    }

    @Test
    void addSuppliesSuccessfully() throws Exception {
        mockMvc.perform(post("/supplies").content(objectMapper.writeValueAsString(supplies))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}
