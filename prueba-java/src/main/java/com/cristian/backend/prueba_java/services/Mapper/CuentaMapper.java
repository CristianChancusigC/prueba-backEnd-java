package com.cristian.backend.prueba_java.services.Mapper;

import com.cristian.backend.prueba_java.models.CuentaModel;
import com.cristian.backend.prueba_java.models.dto.cuenta.CuentaRequestDTO;
import com.cristian.backend.prueba_java.models.dto.cuenta.CuentaResponseDTO;
import com.cristian.backend.prueba_java.models.dto.cuenta.CuentaUpdateDTO;

public class CuentaMapper {

    public static CuentaResponseDTO CovertCuentaResponseDTO(CuentaModel cuentaModel) {
        CuentaResponseDTO cuentaDTO = new CuentaResponseDTO();
        cuentaDTO.setNumeroCuenta(cuentaModel.getNumeroCuenta());
        cuentaDTO.setTipoCuenta(cuentaModel.getTipoCuenta());
        cuentaDTO.setSaldoInicial(cuentaModel.getSaldoInicial());
        cuentaDTO.setEstado(cuentaModel.getEstado());
        cuentaDTO.setNombre(cuentaModel.getCliente().getNombre());
        return cuentaDTO;
    }

    public static CuentaRequestDTO ConvertRequestDTO(CuentaModel cuentaModel) {
        CuentaRequestDTO cuentaDTO = new CuentaRequestDTO();
        cuentaDTO.setNumeroCuenta(cuentaModel.getNumeroCuenta());
        cuentaDTO.setTipoCuenta(cuentaModel.getTipoCuenta());
        cuentaDTO.setSaldoInicial(cuentaModel.getSaldoInicial());
        cuentaDTO.setEstado(cuentaModel.getEstado());
        cuentaDTO.setClienteId(cuentaModel.getCliente().getPersona_id());
        return cuentaDTO;
    }

    public static CuentaUpdateDTO ConvertUpdateDTO(CuentaModel cuentaModel) {
        CuentaUpdateDTO cuentaDTO = new CuentaUpdateDTO();
        cuentaDTO.setSaldoInicial(cuentaModel.getSaldoInicial());
        cuentaDTO.setEstado(cuentaModel.getEstado());
        return cuentaDTO;
    }
}
