package com.nz.kiwi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.enumeration.Taxa;
import com.nz.kiwi.implementation.BirdServiceImpl;
import com.nz.kiwi.implementation.CustomBirdServiceImpl;
import com.nz.kiwi.model.Bird;
import com.nz.kiwi.model.Pit;
import com.nz.kiwi.model.Transmitter;
import com.nz.kiwi.repository.CustomBirdRepository;
import com.nz.kiwi.view.BirdDetailsDto;
import com.nz.kiwi.view.BirdSummaryDto;
import com.nz.kiwi.view.PitDto;
import com.nz.kiwi.view.TransmitterDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.nz.kiwi.ResponseBodyMatchers.responseBody;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
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

    //@MockBean
    //private CustomBirdRepository customBirdRepository;

    @MockBean
    private CustomBirdServiceImpl customBirdService;

    /**
     * test standard bird input (POST)
     */
    @Test
    @DisplayName("Should return a new Bird (POST) and http code 201 (created)")
    void createBird_thenReturns201() throws Exception {

        String requestBody = """
                {
                    "name": "Barry Manilow",
                    "sex": "FEMALE",
                    "taxa": "ROWI",
                    "status": "ALIVE"
                }
                """;

        Bird expectedResponseBody = new Bird(990L, "Barry Manilow", Status.ALIVE, Sex.FEMALE, Taxa.ROWI);
        when(birdService.save(any(Bird.class))).thenReturn(expectedResponseBody);
        mockMvc.perform(post("/kiwis/")
                        .accept(APPLICATION_JSON)
                        .contentType(APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/api/kiwis/"));
        //.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        //.andExpect(responseBody().containsObjectAsJson(expectedResponseBody, Bird.class));
    }

    /**
     * test standard bird input (POST) throws error on null value for name property
     */
    @Test
    void whenNullValue_thenReturns400() throws Exception {
        Bird bird = new Bird();
        bird.setSex(Sex.FEMALE);
        bird.setTaxa(Taxa.BROWN_KIWI);
        bird.setStatus(Status.DECEASED);
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

/*
        PitDto pitDto = new PitDto(20L,"XYRFG213", LocalDate.of(2020, 03, 28), "comment", null);
        TransmitterDto transmitterDto = new Transmitter(98, 1.0, LocalDateTime.of(2020, 03, 28, 12, 45, 00),
                LocalDateTime.of(2020, 03, 28, 13, 00, 00), Transmitter.Type.ATTACHED, "comment");
        BirdDetailsDto birdDetailsDto = new BirdDetailsDto(900L, "Mary", Sex.FEMALE, Status.DECEASED, transmitterDto, pitDto, null);
        String expectedJson = new ObjectMapper().findAndRegisterModules()
                .writeValueAsString(birdDetailsDto);

        this.mockMvc.perform(get("/kiwis/{id}", 900L))
                .andDo(print())
                .andExpect(status().isOk());*/
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
