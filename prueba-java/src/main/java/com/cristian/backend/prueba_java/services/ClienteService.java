package com.cristian.backend.prueba_java.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristian.backend.prueba_java.models.ClienteModel;
import com.cristian.backend.prueba_java.repositories.IClienteRepository;

@Service
public class ClienteService {

    @Autowired
    IClienteRepository clienteRepository;

    public ArrayList<ClienteModel> getClientes() {
        return (ArrayList<ClienteModel>) clienteRepository.findAll();
    }

    public ClienteModel saveCliente(ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }

    public ClienteModel getById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public ClienteModel updateById(ClienteModel request, Long id) {
        ClienteModel cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            cliente.setNombre(request.getNombre());
            cliente.setGenero(request.getGenero());
            cliente.setEdad(request.getEdad());
            cliente.setIdentificacion(request.getIdentificacion());
            cliente.setDireccion(request.getDireccion());
            cliente.setTelefono(request.getTelefono());
            cliente.setContrasena(request.getContrasena());
            cliente.setEstado(request.getEstado());
            return clienteRepository.save(cliente);
        } else {
            return null;
        }
    }

    public Boolean deleteCliente(Long id) {
        try {
            clienteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
