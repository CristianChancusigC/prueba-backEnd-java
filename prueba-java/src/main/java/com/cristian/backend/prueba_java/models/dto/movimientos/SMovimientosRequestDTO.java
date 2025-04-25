package com.cristian.backend.prueba_java.models.dto.movimientos;

public class SMovimientosRequestDTO {
    private Long cuentaId;
    private String tipoMovimiento; // "retiro" o "deposito"
    private Double valor;

    public Long getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Long cuentaId) {
        this.cuentaId = cuentaId;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
