package com.pciber.proyectofloreria.repository;

import com.pciber.proyectofloreria.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
    // Definir métodos adicionales si es necesario
}
