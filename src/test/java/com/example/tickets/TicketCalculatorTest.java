package com.example.tickets;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TicketCalculator.class)
public class TicketCalculatorTest {
    @Autowired

    private MockMvc mvc;

    @Test
    public void priceCalculatorTest() throws Exception{
        String json=getJSON("src/test/resources/request.json");

        MockHttpServletRequestBuilder request =post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);
        this.mvc.perform(request)
               .andExpect(status().isOk());
    }
    private String getJSON(String path) throws Exception{
        Path requestPath= Paths.get(path);
        return new String(Files.readAllBytes(requestPath));
    }
}
