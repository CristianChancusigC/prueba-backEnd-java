package com.cristian.backend.prueba_java.services.Mapper;

import com.cristian.backend.prueba_java.models.ClienteModel;
import com.cristian.backend.prueba_java.models.dto.ClienteDTO;

public class ClienteMapper {

    public static ClienteDTO CovertClienteDTO(ClienteModel clienteModel) {

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNombre(clienteModel.getNombre());
        clienteDTO.setDireccion(clienteModel.getDireccion());
        clienteDTO.setTelefono(clienteModel.getTelefono());
        clienteDTO.setContrasena(clienteModel.getContrasena());
        clienteDTO.setEstado(clienteModel.getEstado());
        return clienteDTO;
    }

}
