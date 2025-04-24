package com.cristian.backend.prueba_java.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Movimientos")
public class MovimientosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_movimiento;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private String tipo_movimiento; // Puede ser "ahorro" o "corriente"

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private Double saldo;

    public Long getId_movimiento() {
        return id_movimiento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipo_movimiento() {
        return tipo_movimiento;
    }

    public void setTipo_movimiento(String tipo_movimiento) {
        this.tipo_movimiento = tipo_movimiento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public CuentaModel getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaModel cuenta) {
        this.cuenta = cuenta;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_id")
    private CuentaModel cuenta;
}
