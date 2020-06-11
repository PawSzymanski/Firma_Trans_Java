package com.trans.trans;

import com.trans.trans.jpa.ReservationJpa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ReservationJpa reservationJpa;

    @Test
    public void reservationTest1() throws Exception {
        mockMvc.perform(get("/api/reservation/all")).andExpect(status().isOk());
    }

    @Test
    public void reservationTest2() throws Exception {
        mockMvc.perform(post("/api/reservation/make")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"roadId\": 1, \"clientName\": \"Marek\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void reservationTest3() throws Exception {
        mockMvc.perform(get("/api/reservation/Marek")).andExpect(status().isOk());
    }

}
