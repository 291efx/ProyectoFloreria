package com.pciber.proyectofloreria.repository;

import com.pciber.proyectofloreria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
    // Definir métodos adicionales si es necesario
}
