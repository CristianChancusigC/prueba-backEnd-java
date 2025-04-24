package com.cristian.backend.prueba_java.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristian.backend.prueba_java.models.ClienteModel;
import com.cristian.backend.prueba_java.services.ClienteService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ArrayList<ClienteModel> getAllClientes() {
        return clienteService.getClientes();
    }

    @GetMapping(path = "/{id}")
    public ClienteModel getClienteById(@PathVariable("id") Long id) {
        return this.clienteService.getById(id);
    }

    @PostMapping
    public ClienteModel saveCliente(@Valid @RequestBody ClienteModel cliente) {
        return this.clienteService.saveCliente(cliente);
    }

    @PutMapping(path = "/{id}")
    public ClienteModel updateClienteById(@Valid @RequestBody ClienteModel request, @PathVariable("id") Long id) {
        return this.clienteService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.clienteService.deleteCliente(id);
        if (ok) {
            return "Cliente eliminado con éxito";
        } else {
            return "Error al eliminar";
        }
    }
}
