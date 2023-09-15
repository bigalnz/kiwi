package com.nz.kiwi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.enumeration.Taxa;
import com.nz.kiwi.model.Bird;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(controllers = KiwiController.class)
public class KiwiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // basic first controller test

    @Test
    void whenValidInput_thenReturns200() throws Exception {

        Bird bird = new Bird("Bobby Brown", Status.ALIVE, Sex.FEMALE, Taxa.BROWN_KIWI);

        mockMvc.perform(post("/kiwis/")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(bird)))
                .andExpect(status().isOk());
    }

}
