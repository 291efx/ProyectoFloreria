package com.pciber.proyectofloreria.repository;

import com.pciber.proyectofloreria.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Integer> {
    // Definir métodos adicionales si es necesario
}
