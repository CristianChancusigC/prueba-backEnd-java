package com.cristian.backend.prueba_java;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import jakarta.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ClienteTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCrearCliente() throws Exception {
        String json = """
                {
                                    "nombre": "Prueba Cliente",
                                    "genero": "Hombre",
                                    "edad": 27,
                                    "identificacion":546789132,
                                    "direccion":"Quito",
                                    "telefono":"098765432",
                                    "contrasena": "123456",
                                    "estado": true
                                }
                                                """;

        mockMvc.perform(post("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void searchClienteById() throws Exception {
        mockMvc.perform(get("/cliente/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Cristian"));
    }
}
