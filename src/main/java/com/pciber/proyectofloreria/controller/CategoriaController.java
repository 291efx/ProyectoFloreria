package com.pciber.proyectofloreria.controller;

import com.pciber.proyectofloreria.model.Categoria;
import com.pciber.proyectofloreria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Obtener todas las categorías
    @GetMapping
    public List<Categoria> getAll() {
        return categoriaService.findAll();
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable Integer id) {
        Categoria categoria = categoriaService.findById(id);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear una nueva categoría
    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Integer id, @RequestBody Categoria categoriaDetails) {
        Categoria updatedCategoria = categoriaService.update(id, categoriaDetails);
        if (updatedCategoria != null) {
            return ResponseEntity.ok(updatedCategoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una categoría
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (categoriaService.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
