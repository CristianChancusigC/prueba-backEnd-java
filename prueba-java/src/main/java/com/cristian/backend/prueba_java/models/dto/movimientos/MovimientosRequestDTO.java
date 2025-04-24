package com.cristian.backend.prueba_java.models.dto.movimientos;

import java.time.LocalDate;

public class MovimientosRequestDTO {
    private LocalDate fecha;
    private String nombre;
    private String numeroCuenta;
    private String tipoMovimiento;
    private Double movimiento;

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Double getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Double movimiento) {
        this.movimiento = movimiento;
    }

}
