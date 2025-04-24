package com.cristian.backend.prueba_java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristian.backend.prueba_java.models.MovimientosModel;

public interface IMovimientoRepository extends JpaRepository<MovimientosModel, Long> {

}
