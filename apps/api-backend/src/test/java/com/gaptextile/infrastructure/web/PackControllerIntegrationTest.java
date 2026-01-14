package com.gaptextile.infrastructure.web;

import com.gaptextile.application.PackService;
import com.gaptextile.domain.Pack;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PackController.class)
class PackControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PackService service;

    @Test
    void shouldReturnAllPacks() throws Exception {
        UUID id = UUID.randomUUID();
        Pack pack = new Pack(id, "Vacances", true, false);
        when(service.getAllPacks()).thenReturn(Collections.singletonList(pack));

        mockMvc.perform(get("/api/packs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Vacances"));
    }

    @Test
    void shouldCreatePack() throws Exception {
        UUID id = UUID.randomUUID();
        Pack pack = new Pack(id, "Ski", true, false);
        when(service.createPack(anyString(), anyBoolean())).thenReturn(pack);

        mockMvc.perform(post("/api/packs")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Ski\", \"isActive\": true}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Ski"));
    }
}
