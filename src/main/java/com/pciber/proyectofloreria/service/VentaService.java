package com.pciber.proyectofloreria.service;

import com.pciber.proyectofloreria.model.Venta;
import com.pciber.proyectofloreria.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private IVentaRepository ventaRepository;

    // Obtener todas las ventas
    public List<Venta> findAll() {
        return ventaRepository.findAll();
    }

    // Obtener una venta por ID
    public Venta findById(Integer id) {
        Optional<Venta> venta = ventaRepository.findById(id);
        return venta.orElse(null); // Retorna null si no se encuentra
    }

    // Guardar una nueva venta
    public Venta save(Venta venta) {
        return ventaRepository.save(venta);
    }

    // Actualizar una venta existente
    public Venta update(Integer id, Venta ventaDetails) {
        if (ventaRepository.existsById(id)) {
            ventaDetails.setIdVenta(id);
            return ventaRepository.save(ventaDetails);
        }
        return null; // Retorna null si no se encuentra
    }

    // Eliminar una venta
    public boolean delete(Integer id) {
        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
            return true; // Eliminación exitosa
        }
        return false; // No se encontró la venta
    }
}
