package com.cristian.backend.prueba_java.services.Mapper;

import com.cristian.backend.prueba_java.models.MovimientosModel;
import com.cristian.backend.prueba_java.models.dto.movimientos.MovimientosDTO;

public class MovimientosMapper {

    public static MovimientosDTO CovertMovimientosDTO(MovimientosModel movimientosModel) {
        MovimientosDTO movimientos = new MovimientosDTO();
        // movimientos.setNumeroCuenta(movimientosModel.getNumeroCuenta());
        movimientos.setTipoMovimiento(movimientosModel.getTipoMovimiento());
        movimientos.setValor(movimientosModel.getValor());
        // movimientos.setEstado(movimientosModel.getEstado());
        // movimientos.setMovimiento(movimientosModel.getMovimiento());
        return movimientos;
    }
}
