package com.cristian.backend.prueba_java.models.dto.movimientos;

import java.time.LocalDate;

public class MovimientoUpdateDTO {
    private LocalDate fecha;
    private Double valor;

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double movimiento) {
        this.valor = movimiento;
    }

}
