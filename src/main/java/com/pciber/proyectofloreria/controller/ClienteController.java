package com.pciber.proyectofloreria.controller;

import com.pciber.proyectofloreria.model.Cliente;
import com.pciber.proyectofloreria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Obtener todos los clientes
    @GetMapping
    public List<Cliente> getAll() {
        return clienteService.findAll();
    }

    // Obtener un cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Integer id) {
        Cliente cliente = clienteService.findById(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo cliente
    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    // Actualizar un cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody Cliente clienteDetails) {
        Cliente updatedCliente = clienteService.update(id, clienteDetails);
        if (updatedCliente != null) {
            return ResponseEntity.ok(updatedCliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (clienteService.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
