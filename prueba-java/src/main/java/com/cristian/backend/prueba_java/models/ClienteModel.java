package com.cristian.backend.prueba_java.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cliente")
public class ClienteModel extends PersonaModel {

    @NotNull(message = "La contraseña no puede estar vacía")
    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private Boolean estado;

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
