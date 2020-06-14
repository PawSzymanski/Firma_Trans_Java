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

    @Test
    public void clientTest1() throws Exception{
        mockMvc.perform(get("/api/clients/all")).andExpect(status().isOk());
    }

    @Test
    public void clientTest2() throws Exception{
        mockMvc.perform(get("/api/clients/roles/1")).andExpect(status().isOk());
    }

    @Test
    public void clientTest3() throws Exception{
        mockMvc.perform(post("/api/clients/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"id\":1, \"login\": \"test\", \"password\": \"test\", \"name\": \"test\", \"surname\": \"test\",\"email\": \"test@test.com\",\"phone\": 987654321}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void connetionTest1() throws Exception{
        mockMvc.perform(get("/api/connection/piwniczna/to/krakow")).andExpect(status().isOk());
    }

    @Test
    public void connetionTest2() throws Exception{
        mockMvc.perform(get("/api/connection/allTrips")).andExpect(status().isOk());
    }
    @Test
    public void connetionTest3() throws Exception{
        mockMvc.perform(get("/api/connection/allConnections")).andExpect(status().isOk());
    }

    @Test
    public void pointsTest1() throws Exception{
        mockMvc.perform(get("/api/points/get/jason")).andExpect(status().isOk());
    }

    @Test
    public void pointsTest2() throws Exception{
        mockMvc.perform(post("/api/points/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"id\":1, \"login\": \"dlelito\", \"points\":300}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void vehicleTest1() throws Exception{
        mockMvc.perform(get("/api/vehicle/1")).andExpect(status().isOk());
    }
}
