package com.cristian.backend.prueba_java.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristian.backend.prueba_java.models.MovimientosModel;
import com.cristian.backend.prueba_java.models.dto.movimientos.MovimientoUpdateDTO;
import com.cristian.backend.prueba_java.models.dto.movimientos.MovimientosRequestDTO;
import com.cristian.backend.prueba_java.models.dto.movimientos.MovimientosResponseDTO;
import com.cristian.backend.prueba_java.repositories.IMovimientoRepository;
import com.cristian.backend.prueba_java.services.Mapper.MovimientosMapper;

@Service
public class MovimientosService {

    @Autowired
    private IMovimientoRepository movimientoRepository;

    public ArrayList<MovimientosResponseDTO> getMovimientosDTO() {
        ArrayList<MovimientosModel> movimientos = (ArrayList<MovimientosModel>) movimientoRepository.findAll();
        ArrayList<MovimientosResponseDTO> movimientosDTO = new ArrayList<>();
        for (MovimientosModel movimiento : movimientos) {
            movimientosDTO.add(MovimientosMapper.CovertMovimientosResponseDTO(movimiento));
        }
        return movimientosDTO;
    }

    // public MovimientosModel saveMovimiento(MovimientosModel movimiento) {
    // return movimientoRepository.save(movimiento);
    // }
    public MovimientosRequestDTO saveMovimientoDTO(MovimientosModel movimiento) {
        movimiento = movimientoRepository.save(movimiento);
        MovimientosRequestDTO movimientoDTO = new MovimientosRequestDTO();
        movimientoDTO = MovimientosMapper.ConvertRequestDTO(movimiento);
        return movimientoDTO;
    }

    public MovimientosResponseDTO getByIdDTO(Long id) {
        MovimientosModel movimiento = movimientoRepository.findById(id).orElse(null);
        if (movimiento != null) {
            return MovimientosMapper.CovertMovimientosResponseDTO(movimiento);
        } else {
            return null;
        }
    }

    // public MovimientosModel updateById(MovimientosModel request, Long id) {
    // MovimientosModel movimiento = movimientoRepository.findById(id).orElse(null);
    // if (movimiento != null) {
    // movimiento.setTipoMovimiento(request.getTipoMovimiento());
    // movimiento.setValor(request.getValor());
    // movimiento.setFecha(request.getFecha());
    // return movimientoRepository.save(movimiento);
    // } else {
    // return null;
    // }
    // }

    public MovimientoUpdateDTO updateByIdDTO(MovimientosModel request, Long id) {
        MovimientosModel movimiento = movimientoRepository.findById(id).orElse(null);
        if (movimiento != null) {
            movimiento.setFecha(request.getFecha());
            movimiento.setValor(request.getValor());
            return MovimientosMapper.ConvertUpdateDTO(movimientoRepository.save(movimiento));
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
