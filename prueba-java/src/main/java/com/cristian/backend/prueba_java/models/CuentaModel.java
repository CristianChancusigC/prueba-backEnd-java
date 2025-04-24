package com.cristian.backend.prueba_java.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "cuenta")
public class CuentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cuenta_id;

    @Column(unique = true, nullable = false)
    private Long numero_cuenta;

    @Column(nullable = false)
    private String tipo_cuenta;

    @Column(nullable = false)
    private Double saldo_inicial;

    @Column(nullable = false)
    private Boolean estado;

    public Long getCuenta_id() {
        return cuenta_id;
    }

    public Long getNumeroCuenta() {
        return numero_cuenta;
    }

    public void setNumeroCuenta(Long numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public String getTipoCuenta() {
        return tipo_cuenta;
    }

    public void setTipoCuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public Double getSaldoInicial() {
        return saldo_inicial;
    }

    public void setSaldoInicial(Double saldo_inicial) {
        this.saldo_inicial = saldo_inicial;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private ClienteModel cliente;
}
