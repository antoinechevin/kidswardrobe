package com.gaptextile.infrastructure.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaptextile.application.ChildService;
import com.gaptextile.domain.Child;
import com.gaptextile.domain.ClothingSize;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ChildController.class)
class ChildControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChildService childService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllChildren_ShouldReturnList() throws Exception {
        when(childService.getAllChildren())
                .thenReturn(List.of(new Child(UUID.randomUUID(), "Bob", ClothingSize.SIZE_3M)));

        mockMvc.perform(get("/api/children"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Bob"));
    }

    @Test
    void createChild_ShouldReturnCreated() throws Exception {
        Child child = new Child(UUID.randomUUID(), "Charlie", ClothingSize.SIZE_9M);
        when(childService.createChild("Charlie", "9M")).thenReturn(child);

        mockMvc.perform(post("/api/children")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new ChildController.ChildRequest("Charlie", "9M"))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Charlie"));
    }
}
