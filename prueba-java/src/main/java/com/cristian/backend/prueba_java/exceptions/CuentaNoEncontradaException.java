package com.cristian.backend.prueba_java.exceptions;

public class CuentaNoEncontradaException extends RuntimeException {
    public CuentaNoEncontradaException(String message) {
        super(message);
    }

}
