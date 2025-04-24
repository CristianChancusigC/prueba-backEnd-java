package com.cristian.backend.prueba_java.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "persona")
public class PersonaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long persona_id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Column(nullable = false)
    private String nombre;

    @Column
    private String genero;

    @Min(value = 0, message = "La edad no puede ser menor a 0")
    @Column
    private int edad;

    @NotBlank(message = "La identificación no puede estar vacía")
    @Column(nullable = false)
    private int identificacion;

    @Column
    private String direccion;

    @Column
    private String telefono;

    public Long getPersona_id() {
        return persona_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
