package com.currency.exchange.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class GifExchangeRateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getFunnyGif() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/api/gif/")
                        .param("base", "aed")).andExpect(status().isOk());
        assertThat(resultActions.andReturn().getResponse().getContentAsByteArray()).isNotEmpty();
    }

    @Test
    void badeRequset() throws Exception{
        mockMvc.perform(get("/api/gif/")
                        .param("base", "sdasfewewtwe"))
                .andExpect(status().isBadRequest());
    }
}