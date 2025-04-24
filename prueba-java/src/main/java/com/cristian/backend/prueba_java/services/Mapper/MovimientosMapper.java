package com.cristian.backend.prueba_java.services.Mapper;

import com.cristian.backend.prueba_java.models.MovimientosModel;
import com.cristian.backend.prueba_java.models.dto.movimientos.MovimientoUpdateDTO;
import com.cristian.backend.prueba_java.models.dto.movimientos.MovimientosRequestDTO;
import com.cristian.backend.prueba_java.models.dto.movimientos.MovimientosResponseDTO;

public class MovimientosMapper {

    // public static MovimientosResponseDTO
    // CovertMovimientosResponseDTO(MovimientosModel movimientosModel) {
    // MovimientosResponseDTO movimientos = new MovimientosResponseDTO();
    // movimientos.setNumeroCuenta(movimientosModel.getCuenta().getNumeroCuenta());
    // movimientos.setTipoMovimiento(movimientosModel.getTipoMovimiento());
    // movimientos.setSaldoInicial(movimientosModel.getValor());
    // movimientos.setEstado(movimientosModel.getCuenta().getEstado());
    // movimientos.setMovimiento(movimientosModel.getValor());
    // return movimientos;
    // }

    public static MovimientosResponseDTO CovertMovimientosResponseDTO(MovimientosModel movimientosModel) {
        MovimientosResponseDTO movimientos = new MovimientosResponseDTO();
        movimientos.setFecha(movimientosModel.getFecha());
        movimientos.setNombre(movimientosModel.getCuenta().getCliente().getNombre());
        movimientos.setNumeroCuenta(movimientosModel.getCuenta().getNumeroCuenta());
        movimientos.setTipoMovimiento(movimientosModel.getTipoMovimiento());
        movimientos.setSaldoInicial(movimientosModel.getValor());
        movimientos.setEstado(movimientosModel.getCuenta().getEstado());
        movimientos.setMovimiento(movimientosModel.getValor());
        return movimientos;
    }

    public static MovimientosRequestDTO ConvertRequestDTO(MovimientosModel movimientosModel) {
        MovimientosRequestDTO movimientos = new MovimientosRequestDTO();
        movimientos.setFecha(movimientosModel.getFecha());
        movimientos.setNombre(movimientosModel.getCuenta().getCliente().getNombre());
        movimientos.setNumeroCuenta(movimientosModel.getCuenta().getNumeroCuenta());
        movimientos.setTipoMovimiento(movimientosModel.getTipoMovimiento());
        movimientos.setMovimiento(movimientosModel.getValor());
        return movimientos;
    }

    public static MovimientoUpdateDTO ConvertUpdateDTO(MovimientosModel movimientosModel) {
        MovimientoUpdateDTO movimientos = new MovimientoUpdateDTO();
        movimientos.setFecha(movimientosModel.getFecha());
        movimientos.setValor(movimientosModel.getValor());
        return movimientos;
    }
}
