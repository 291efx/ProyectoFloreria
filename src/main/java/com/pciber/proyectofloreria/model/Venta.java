package com.pciber.proyectofloreria.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "venta")
@Data
@Getter
@Setter
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVenta")
    private Integer idVenta;

    @Column(name = "idCliente")
    private Integer idCliente;

    @Column(name = "fVenta")
    @Temporal(TemporalType.DATE)
    private Date fVenta;

    @Column(name = "mTotal", nullable = false)
    private Double mTotal;

    @Column(name = "estado", length = 100)
    private String estado;
}
