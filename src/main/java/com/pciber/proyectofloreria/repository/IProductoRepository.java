package com.pciber.proyectofloreria.repository;

import com.pciber.proyectofloreria.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {
    // Definir métodos adicionales si es necesario
}
