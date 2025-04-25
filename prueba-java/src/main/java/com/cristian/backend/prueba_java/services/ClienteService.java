package com.cristian.backend.prueba_java.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristian.backend.prueba_java.exceptions.ClienteNoEncontradoException;
import com.cristian.backend.prueba_java.models.ClienteModel;
import com.cristian.backend.prueba_java.models.dto.cliente.ClienteRequestDTO;
import com.cristian.backend.prueba_java.models.dto.cliente.ClienteResponseDTO;
import com.cristian.backend.prueba_java.models.dto.cliente.ClienteUpdateDTO;
import com.cristian.backend.prueba_java.repositories.IClienteRepository;
import com.cristian.backend.prueba_java.services.Mapper.ClienteMapper;

@Service
public class ClienteService {

    @Autowired
    IClienteRepository clienteRepository;

    public ArrayList<ClienteResponseDTO> getClientesDTO() {
        ArrayList<ClienteModel> clientes = (ArrayList<ClienteModel>) clienteRepository.findAll();
        ArrayList<ClienteResponseDTO> clientesDTO = new ArrayList<>();
        for (ClienteModel cliente : clientes) {
            clientesDTO.add(ClienteMapper.CovertClienteResponseDTO(cliente));
        }
        return clientesDTO;
    }

    public ClienteRequestDTO saveClienteDTO(ClienteModel cliente) {
        cliente = clienteRepository.save(cliente);
        ClienteRequestDTO clienteDTO = new ClienteRequestDTO();
        clienteDTO = ClienteMapper.CovertClienteRequestDTO(cliente);
        return clienteDTO;
    }

    public ClienteResponseDTO getByIdDTO(Long id) {
        ClienteModel cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNoEncontradoException("Cliente no encontrado con id: " + id));
        if (cliente != null) {
            return ClienteMapper.CovertClienteResponseDTO(cliente);
        } else {
            return null;
        }
    }

    public ClienteUpdateDTO updateByIdDTO(ClienteModel request, Long id) {
        ClienteModel cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNoEncontradoException("Cliente no encontrado con id: " + id));
        if (cliente != null) {
            cliente.setNombre(request.getNombre());
            cliente.setGenero(request.getGenero());
            cliente.setEdad(request.getEdad());
            cliente.setIdentificacion(request.getIdentificacion());
            cliente.setDireccion(request.getDireccion());
            cliente.setTelefono(request.getTelefono());
            cliente.setContrasena(request.getContrasena());
            cliente.setEstado(request.getEstado());
            return ClienteMapper.CovertClienteUpdateDTO(clienteRepository.save(cliente));
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
