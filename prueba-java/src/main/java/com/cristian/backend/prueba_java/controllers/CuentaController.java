package com.cristian.backend.prueba_java.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristian.backend.prueba_java.models.CuentaModel;
import com.cristian.backend.prueba_java.models.dto.cuenta.CuentaRequestDTO;
import com.cristian.backend.prueba_java.models.dto.cuenta.CuentaResponseDTO;
import com.cristian.backend.prueba_java.models.dto.cuenta.CuentaUpdateDTO;
import com.cristian.backend.prueba_java.services.CuentaService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public ArrayList<CuentaResponseDTO> getAllCuentas() {
        return this.cuentaService.getCuentasDTO();
    }

    @GetMapping(path = "/{id}")
    public CuentaResponseDTO getCuentaById(@PathVariable("id") Long id) {

        return this.cuentaService.getByIdODT(id);
    }

    @PostMapping
    public CuentaRequestDTO saveCuenta(@Valid @RequestBody CuentaModel cuenta) {
        return this.cuentaService.saveCuentaDTO(cuenta);
    }

    @PutMapping(path = "/{id}")
    public CuentaUpdateDTO updateCuentaById(@Valid @RequestBody CuentaModel request, @PathVariable("id") Long id) {
        return this.cuentaService.updateByIdDTO(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.cuentaService.deleteCuenta(id);
        if (ok) {
            return "Cuenta eliminada con éxito";
        } else {
            return "Error al eliminar";
        }
    }
}
