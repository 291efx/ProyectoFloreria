package com.pciber.proyectofloreria.service;

import com.pciber.proyectofloreria.model.Categoria;
import com.pciber.proyectofloreria.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private ICategoriaRepository categoriaRepository;

    // Obtener todas las categorías
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    // Obtener una categoría por ID
    public Categoria findById(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElse(null); // Retorna null si no se encuentra
    }

    // Guardar una nueva categoría
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Actualizar una categoría existente
    public Categoria update(Integer id, Categoria categoriaDetails) {
        if (categoriaRepository.existsById(id)) {
            categoriaDetails.setIdCategoria(id);
            return categoriaRepository.save(categoriaDetails);
        }
        return null; // Retorna null si no se encuentra
    }

    // Eliminar una categoría
    public boolean delete(Integer id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true; // Eliminación exitosa
        }
        return false; // No se encontró la categoría
    }
}
