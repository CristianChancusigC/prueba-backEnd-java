package com.cristian.backend.prueba_java.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristian.backend.prueba_java.exceptions.CuentaNoEncontradaException;
import com.cristian.backend.prueba_java.models.ClienteModel;
import com.cristian.backend.prueba_java.models.CuentaModel;
import com.cristian.backend.prueba_java.models.dto.cuenta.CuentaRequestDTO;
import com.cristian.backend.prueba_java.models.dto.cuenta.CuentaResponseDTO;
import com.cristian.backend.prueba_java.models.dto.cuenta.CuentaUpdateDTO;
import com.cristian.backend.prueba_java.repositories.IClienteRepository;
import com.cristian.backend.prueba_java.repositories.ICuentaRepository;
import com.cristian.backend.prueba_java.services.Mapper.CuentaMapper;

@Service
public class CuentaService {

    @Autowired
    private ICuentaRepository cuentaRepository;

    @Autowired
    private IClienteRepository clienteRepository;

    public ArrayList<CuentaResponseDTO> getCuentasDTO() {
        ArrayList<CuentaModel> cuentas = (ArrayList<CuentaModel>) cuentaRepository.findAll();
        ArrayList<CuentaResponseDTO> cuentasDTO = new ArrayList<>();
        for (CuentaModel cuenta : cuentas) {
            cuentasDTO.add(CuentaMapper.CovertCuentaResponseDTO(cuenta));
        }
        return cuentasDTO;
    }

    public CuentaRequestDTO saveCuentaDTO(CuentaRequestDTO cuentaRequestDTO) {
        ClienteModel cliente = clienteRepository.findById(cuentaRequestDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        CuentaModel cuenta = new CuentaModel();
        cuenta.setNumeroCuenta(cuentaRequestDTO.getNumeroCuenta());
        cuenta.setTipoCuenta(cuentaRequestDTO.getTipoCuenta());
        cuenta.setSaldoInicial(cuentaRequestDTO.getSaldoInicial());
        cuenta.setEstado(cuentaRequestDTO.getEstado());
        cuenta.setCliente(cliente);

        cuenta = cuentaRepository.save(cuenta);

        return CuentaMapper.ConvertRequestDTO(cuenta);
    }

    public CuentaResponseDTO getByIdODT(Long id) {
        CuentaModel cuenta = cuentaRepository.findById(id)
                .orElseThrow(() -> new CuentaNoEncontradaException("Cuenta no encontrada con id: " + id));
        if (cuenta != null) {
            return CuentaMapper.CovertCuentaResponseDTO(cuenta);
        } else {
            return null;
        }
    }

    public CuentaUpdateDTO updateByIdDTO(CuentaModel request, Long id) {
        CuentaModel cuenta = cuentaRepository.findById(id)
                .orElseThrow(() -> new CuentaNoEncontradaException("Cuenta no encontrada con id: " + id));
        if (cuenta != null) {
            cuenta.setSaldoInicial(request.getSaldoInicial());
            cuenta.setEstado(request.getEstado());
            return CuentaMapper.ConvertUpdateDTO(cuentaRepository.save(cuenta));
        } else {
            return null;
        }
    }

    public Boolean deleteCuenta(Long id) {
        try {
            cuentaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
