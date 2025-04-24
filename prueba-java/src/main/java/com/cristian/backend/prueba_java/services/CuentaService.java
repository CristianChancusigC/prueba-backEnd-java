package com.cristian.backend.prueba_java.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristian.backend.prueba_java.models.CuentaModel;
import com.cristian.backend.prueba_java.models.dto.cuenta.CuentaRequestDTO;
import com.cristian.backend.prueba_java.models.dto.cuenta.CuentaResponseDTO;
import com.cristian.backend.prueba_java.models.dto.cuenta.CuentaUpdateDTO;
import com.cristian.backend.prueba_java.repositories.ICuentaRepository;
import com.cristian.backend.prueba_java.services.Mapper.CuentaMapper;

@Service
public class CuentaService {

    @Autowired
    private ICuentaRepository cuentaRepository;

    public ArrayList<CuentaResponseDTO> getCuentasDTO() {
        ArrayList<CuentaModel> cuentas = (ArrayList<CuentaModel>) cuentaRepository.findAll();
        ArrayList<CuentaResponseDTO> cuentasDTO = new ArrayList<>();
        for (CuentaModel cuenta : cuentas) {
            cuentasDTO.add(CuentaMapper.CovertCuentaResponseDTO(cuenta));
        }
        return cuentasDTO;
    }

    public CuentaRequestDTO saveCuentaDTO(CuentaModel cuenta) {
        cuenta = cuentaRepository.save(cuenta);
        CuentaRequestDTO cuentaDTO = new CuentaRequestDTO();
        cuentaDTO = CuentaMapper.ConvertRequestDTO(cuenta);
        return cuentaDTO;
    }

    public CuentaResponseDTO getByIdODT(Long id) {
        CuentaModel cuenta = cuentaRepository.findById(id).orElse(null);
        if (cuenta != null) {
            return CuentaMapper.CovertCuentaResponseDTO(cuenta);
        } else {
            return null;
        }
    }

    public CuentaUpdateDTO updateByIdDTO(CuentaModel request, Long id) {
        CuentaModel cuenta = cuentaRepository.findById(id).orElse(null);
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
