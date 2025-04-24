package com.cristian.backend.prueba_java.services.Mapper;

import com.cristian.backend.prueba_java.models.ClienteModel;
import com.cristian.backend.prueba_java.models.dto.cliente.ClienteRequestDTO;
import com.cristian.backend.prueba_java.models.dto.cliente.ClienteResponseDTO;
import com.cristian.backend.prueba_java.models.dto.cliente.ClienteUpdateDTO;

public class ClienteMapper {

    public static ClienteResponseDTO CovertClienteResponseDTO(ClienteModel clienteModel) {

        ClienteResponseDTO clienteDTO = new ClienteResponseDTO();
        clienteDTO.setNombre(clienteModel.getNombre());
        clienteDTO.setDireccion(clienteModel.getDireccion());
        clienteDTO.setTelefono(clienteModel.getTelefono());
        clienteDTO.setContrasena(clienteModel.getContrasena());
        clienteDTO.setEstado(clienteModel.getEstado());
        return clienteDTO;
    }

    public static ClienteRequestDTO CovertClienteRequestDTO(ClienteModel clienteModel) {

        ClienteRequestDTO clienteDTO = new ClienteRequestDTO();
        clienteDTO.setNombre(clienteModel.getNombre());
        clienteDTO.setGenero(clienteModel.getGenero());
        clienteDTO.setEdad(clienteModel.getEdad());
        clienteDTO.setIdentificacion(clienteModel.getIdentificacion());
        clienteDTO.setDireccion(clienteModel.getDireccion());
        clienteDTO.setTelefono(clienteModel.getTelefono());
        clienteDTO.setContrasena(clienteModel.getContrasena());
        clienteDTO.setEstado(clienteModel.getEstado());
        return clienteDTO;
    }

    public static ClienteUpdateDTO CovertClienteUpdateDTO(ClienteModel clienteModel) {

        ClienteUpdateDTO clienteDTO = new ClienteUpdateDTO();
        clienteDTO.setNombre(clienteModel.getNombre());
        clienteDTO.setGenero(clienteModel.getGenero());
        clienteDTO.setEdad(clienteModel.getEdad());
        clienteDTO.setIdentificacion(clienteModel.getIdentificacion());
        clienteDTO.setDireccion(clienteModel.getDireccion());
        clienteDTO.setTelefono(clienteModel.getTelefono());
        clienteDTO.setContrasena(clienteModel.getContrasena());
        clienteDTO.setEstado(clienteModel.getEstado());
        return clienteDTO;
    }

}
