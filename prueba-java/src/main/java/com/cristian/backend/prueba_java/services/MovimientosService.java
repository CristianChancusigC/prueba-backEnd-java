package com.cristian.backend.prueba_java.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristian.backend.prueba_java.models.MovimientosModel;
import com.cristian.backend.prueba_java.models.dto.movimientos.MovimientosDTO;
import com.cristian.backend.prueba_java.repositories.IMovimientoRepository;
import com.cristian.backend.prueba_java.services.Mapper.MovimientosMapper;

@Service
public class MovimientosService {

    @Autowired
    private IMovimientoRepository movimientoRepository;

    public ArrayList<MovimientosModel> getMovimientos() {
        return (ArrayList<MovimientosModel>) movimientoRepository.findAll();
    }

    public ArrayList<MovimientosDTO> getMovimientosDTO() {
        ArrayList<MovimientosModel> movimientos = (ArrayList<MovimientosModel>) movimientoRepository.findAll();
        ArrayList<MovimientosDTO> movimientosDTO = new ArrayList<>();
        for (MovimientosModel movimiento : movimientos) {
            movimientosDTO.add(MovimientosMapper.CovertMovimientosDTO(movimiento));
        }
        return movimientosDTO;
    }

    public MovimientosModel saveMovimiento(MovimientosModel movimiento) {
        return movimientoRepository.save(movimiento);
    }

    public MovimientosModel getById(Long id) {
        return movimientoRepository.findById(id).orElse(null);
    }

    public MovimientosModel updateById(MovimientosModel request, Long id) {
        MovimientosModel movimiento = movimientoRepository.findById(id).orElse(null);
        if (movimiento != null) {
            movimiento.setTipoMovimiento(request.getTipoMovimiento());
            movimiento.setValor(request.getValor());
            movimiento.setFecha(request.getFecha());
            return movimientoRepository.save(movimiento);
        } else {
            return null;
        }
    }

    public Boolean deleteMovimiento(Long id) {
        try {
            movimientoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
