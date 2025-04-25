package com.cristian.backend.prueba_java.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cristian.backend.prueba_java.exceptions.ClienteNoEncontradoException;
import com.cristian.backend.prueba_java.exceptions.CuentaNoEncontradaException;
import com.cristian.backend.prueba_java.exceptions.MovimientoNoEncontradoException;
import com.cristian.backend.prueba_java.exceptions.SaldoInsuficienteException;
import com.cristian.backend.prueba_java.exceptions.ValorIngresadoException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SaldoInsuficienteException.class)
    public ResponseEntity<Map<String, String>> handleSaldoInsuficiente(SaldoInsuficienteException ex) {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", ex.getMessage());
        return ResponseEntity.badRequest().body(respuesta);
    }

    @ExceptionHandler(CuentaNoEncontradaException.class)
    public ResponseEntity<Map<String, String>> handleCuentaNoEncontrada(CuentaNoEncontradaException ex) {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", ex.getMessage());
        return ResponseEntity.badRequest().body(respuesta);
    }

    @ExceptionHandler(ClienteNoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handleClienteNoEncontrado(ClienteNoEncontradoException ex) {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", ex.getMessage());
        return ResponseEntity.badRequest().body(respuesta);
    }

    @ExceptionHandler(MovimientoNoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handleMovimientoNoEncontrado(MovimientoNoEncontradoException ex) {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", ex.getMessage());
        return ResponseEntity.badRequest().body(respuesta);
    }

    @ExceptionHandler(ValorIngresadoException.class)
    public ResponseEntity<Map<String, String>> handleValorIngresado(ValorIngresadoException ex) {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", ex.getMessage());
        return ResponseEntity.badRequest().body(respuesta);
    }

}
