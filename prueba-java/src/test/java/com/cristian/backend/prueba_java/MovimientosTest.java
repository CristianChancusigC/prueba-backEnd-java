package com.cristian.backend.prueba_java;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import jakarta.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class MovimientosTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCrearMovimiento() throws Exception {
        String json = """
                                {
                    "cuentaId": 1,
                    "tipoMovimiento": "Ahorro",
                    "valor": 40
                }
                                """;

        mockMvc.perform(post("/movimientos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void testFueraRangoMovimiento() throws Exception {
        String json = """
                    {
                    "cuentaId": 1,
                    "tipoMovimiento": "Ahorro",
                            "valor": -10000
                            }
                """;
        mockMvc.perform(post("/movimientos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.mensaje").value("Saldo insuficiente para realizar el movimiento"));
    }
}
