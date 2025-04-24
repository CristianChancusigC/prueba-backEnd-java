package com.cristian.backend.prueba_java.models.dto.cuenta;

public class CuentaResponseDTO {
    private String numeroCuenta;
    private String tipoCuenta;
    private Double saldo_inicial;
    private Boolean estado;
    private String nombre;

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Double getSaldoInicial() {
        return saldo_inicial;
    }

    public void setSaldoInicial(Double saldo) {
        this.saldo_inicial = saldo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
