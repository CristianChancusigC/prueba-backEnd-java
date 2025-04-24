package com.cristian.backend.prueba_java.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristian.backend.prueba_java.models.MovimientosModel;
import com.cristian.backend.prueba_java.models.dto.movimientos.MovimientoUpdateDTO;
import com.cristian.backend.prueba_java.models.dto.movimientos.MovimientosRequestDTO;
import com.cristian.backend.prueba_java.models.dto.movimientos.MovimientosResponseDTO;
import com.cristian.backend.prueba_java.services.MovimientosService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/movimientos")
public class MovimientosController {
    @Autowired
    private MovimientosService movimientosService;

    @GetMapping
    public ArrayList<MovimientosResponseDTO> getAllMovimientos() {
        return this.movimientosService.getMovimientosDTO();
    }

    @GetMapping(path = "/{id}")
    public MovimientosResponseDTO getMovimientoById(@PathVariable("id") Long id) {
        return this.movimientosService.getByIdDTO(id);
    }

    @PostMapping
    public MovimientosRequestDTO saveMovimiento(@RequestBody MovimientosModel movimiento) {
        return this.movimientosService.saveMovimientoDTO(movimiento);
    }

    @PutMapping(path = "/{id}")
    public MovimientoUpdateDTO updateMovimientoById(@RequestBody MovimientosModel request,
            @PathVariable("id") Long id) {
        return this.movimientosService.updateByIdDTO(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.movimientosService.deleteMovimiento(id);
        if (ok) {
            return "Movimiento eliminado con éxito";
        } else {
            return "Error al eliminar";
        }
    }
}
