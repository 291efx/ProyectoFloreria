package com.pciber.proyectofloreria.service;

import com.pciber.proyectofloreria.model.Cliente;
import com.pciber.proyectofloreria.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    // Obtener todos los clientes
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    // Obtener un cliente por ID
    public Cliente findById(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null); // Retorna null si no se encuentra
    }

    // Guardar un nuevo cliente
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Actualizar un cliente existente
    public Cliente update(Integer id, Cliente clienteDetails) {
        if (clienteRepository.existsById(id)) {
            clienteDetails.setIdCliente(id);
            return clienteRepository.save(clienteDetails);
        }
        return null; // Retorna null si no se encuentra
    }

    // Eliminar un cliente
    public boolean delete(Integer id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true; // Eliminación exitosa
        }
        return false; // No se encontró el cliente
    }
}
