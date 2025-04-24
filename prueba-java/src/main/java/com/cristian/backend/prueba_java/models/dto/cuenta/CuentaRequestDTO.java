package com.cristian.backend.prueba_java.models.dto.cuenta;

public class CuentaRequestDTO {
    private String numeroCuenta;
    private String tipoCuenta;
    private Double saldo_inicial;
    private Boolean estado;
    private Long cliente_id;

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

    public Long getClienteId() {
        return cliente_id;
    }

    public void setClienteId(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

}
