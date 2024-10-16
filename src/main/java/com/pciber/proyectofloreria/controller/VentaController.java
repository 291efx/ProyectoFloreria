package com.pciber.proyectofloreria.controller;

import com.pciber.proyectofloreria.model.Venta;
import com.pciber.proyectofloreria.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    // Obtener todas las ventas
    @GetMapping
    public List<Venta> getAll() {
        return ventaService.findAll();
    }

    // Obtener una venta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Venta> getById(@PathVariable Integer id) {
        Venta venta = ventaService.findById(id);
        if (venta != null) {
            return ResponseEntity.ok(venta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear una nueva venta
    @PostMapping
    public Venta create(@RequestBody Venta venta) {
        return ventaService.save(venta);
    }

    // Actualizar una venta existente
    @PutMapping("/{id}")
    public ResponseEntity<Venta> update(@PathVariable Integer id, @RequestBody Venta ventaDetails) {
        Venta updatedVenta = ventaService.update(id, ventaDetails);
        if (updatedVenta != null) {
            return ResponseEntity.ok(updatedVenta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una venta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (ventaService.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
