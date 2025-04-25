package com.cristian.backend.prueba_java.exceptions;

public class ClienteNoEncontradoException extends RuntimeException {
    public ClienteNoEncontradoException(String message) {
        super(message);
    }

}
