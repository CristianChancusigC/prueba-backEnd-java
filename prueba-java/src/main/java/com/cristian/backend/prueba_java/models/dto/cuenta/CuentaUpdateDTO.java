package com.cristian.backend.prueba_java.models.dto.cuenta;

public class CuentaUpdateDTO {
    private Double saldo_inicial;
    private Boolean estado;

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

}
