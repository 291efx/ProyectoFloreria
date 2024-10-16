package com.pciber.proyectofloreria.service;

import com.pciber.proyectofloreria.model.Producto;
import com.pciber.proyectofloreria.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    // Obtener todos los productos
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    // Obtener un producto por ID
    public Producto findById(Integer id) {
        Optional<Producto> producto = productoRepository.findById(id);
        return producto.orElse(null); // Retorna null si no se encuentra
    }

    // Guardar un nuevo producto
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    // Actualizar un producto existente
    public Producto update(Integer id, Producto productoDetails) {
        if (productoRepository.existsById(id)) {
            productoDetails.setIdProducto(id);
            return productoRepository.save(productoDetails);
        }
        return null; // Retorna null si no se encuentra
    }

    // Eliminar un producto
    public boolean delete(Integer id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true; // Eliminación exitosa
        }
        return false; // No se encontró el producto
    }
}
