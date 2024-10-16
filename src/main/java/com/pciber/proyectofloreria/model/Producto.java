package com.pciber.proyectofloreria.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "producto")
@Data
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Integer idProducto;

    @Column(name = "idCategoria")
    private Integer idCategoria;

    @Column(name = "descripcion", length = 255, nullable = false)
    private String descripcion;

    @Column(name = "precioUnidad", nullable = false)
    private Double precioUnidad;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "imagen", length = 255)
    private String imagen;

    @Column(name = "estado", length = 100)
    private String estado;
}
