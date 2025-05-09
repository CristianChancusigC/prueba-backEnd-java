package com.cristian.backend.prueba_java.models.dto.movimientos;

import java.time.LocalDate;

public class MovimientosResponseDTO {
    private LocalDate fecha;
    private String nombre;
    private String numeroCuenta;
    private String tipoMovimiento;
    private Double saldo_inicial;
    private Boolean estado;
    private Double movimiento;
    private Double saldoDisponible;

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

    public Double getSaldoInicial() {
        return saldo_inicial;
    }

    public void setSaldoInicial(Double valor) {
        this.saldo_inicial = valor;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Double getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Double saldo) {
        this.movimiento = saldo;
    }

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

    public Double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(Double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

}
