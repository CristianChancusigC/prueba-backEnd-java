package com.cristian.backend.prueba_java.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristian.backend.prueba_java.models.CuentaModel;
import com.cristian.backend.prueba_java.repositories.ICuentaRepository;

@Service
public class CuentaService {

    @Autowired
    private ICuentaRepository cuentaRepository;

    public ArrayList<CuentaModel> getCuentas() {
        return (ArrayList<CuentaModel>) cuentaRepository.findAll();
    }

    public CuentaModel saveCuenta(CuentaModel cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public CuentaModel getById(Long id) {
        return cuentaRepository.findById(id).orElse(null);
    }

    public CuentaModel updateById(CuentaModel request, Long id) {
        CuentaModel cuenta = cuentaRepository.findById(id).orElse(null);
        if (cuenta != null) {
            cuenta.setNumeroCuenta(request.getNumeroCuenta());
            cuenta.setTipoCuenta(request.getTipoCuenta());
            cuenta.setSaldoInicial(request.getSaldoInicial());
            cuenta.setEstado(request.getEstado());
            return cuentaRepository.save(cuenta);
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
