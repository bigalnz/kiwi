package com.nz.kiwi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.enumeration.Taxa;
import com.nz.kiwi.implementation.BirdServiceImpl;
import com.nz.kiwi.model.Bird;
import com.nz.kiwi.model.Pit;
import com.nz.kiwi.model.Transmitter;
import com.nz.kiwi.repository.CustomBirdRepositoryImpl;
import com.nz.kiwi.view.BirdDetailsDto;
import com.nz.kiwi.view.BirdSummaryDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(controllers = KiwiController.class)
public class KiwiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BirdServiceImpl birdService;

    @MockBean
    private CustomBirdRepositoryImpl customBirdRepository;

    /**
     * test standard bird input (POST)
     */
    @Test
    @DisplayName("Should return a new Bird (POST) and http code 201 (created)")
    void createBird_thenReturns201() throws Exception {
        Bird bird = new Bird("Bobby Brown", Status.ALIVE, Sex.FEMALE, Taxa.BROWN_KIWI);

        mockMvc.perform(post("/kiwis/")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(bird)))
                .andExpect(status().isCreated());
    }

    /**
     * test standard bird input (POST) throws error on null value for name property
     */
    @Test
    void whenNullValue_thenReturns400() throws Exception {
        Bird bird = new Bird(null, Status.ALIVE, Sex.FEMALE, Taxa.BROWN_KIWI);

        mockMvc.perform(post("/kiwis/")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(bird)))
                .andExpect(status().isBadRequest());
    }

    /**
     * test standard BirdDetailsDto (GET)
     */
    @Test
    void shouldReturnBirdDetailsDto() throws Exception {


        Pit pit = new Pit("XYRFG213", LocalDate.of(2020, 03, 28), "comment");
        Transmitter transmitter = new Transmitter(98, 1.0, LocalDateTime.of(2020, 03, 28, 12, 45, 00),
                LocalDateTime.of(2020, 03, 28, 13, 00, 00), Transmitter.Type.ATTACHED, "comment");
        BirdDetailsDto birdDetailsDto = new BirdDetailsDto(900L, "Mary", Sex.FEMALE, Status.DECEASED, transmitter, pit, null, null);
        String expectedJson = new ObjectMapper().findAndRegisterModules()
                .writeValueAsString(birdDetailsDto);

        this.mockMvc.perform(get("/kiwis/{id}", 900L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnListOfBirdSummaryDto() throws Exception {
        List<BirdSummaryDto> birdSummaryDtoList = new ArrayList<>(
                Arrays.asList(new BirdSummaryDto(5L, "Mary", Sex.MALE, Status.ALIVE),
                        new BirdSummaryDto(10L, "Robert", Sex.FEMALE, Status.DECEASED),
                        new BirdSummaryDto(20L, "James", Sex.FEMALE, Status.DECEASED)));

        when(birdService.listBirdSummaryDTO()).thenReturn(birdSummaryDtoList);

        mockMvc.perform(get("/kiwis/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andDo(print());
    }
}
