package com.pciber.proyectofloreria.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "cliente")
@Data
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Integer idCliente;

    @Column(name = "apellidos", length = 100, nullable = false)
    private String apellidos;

    @Column(name = "nombres", length = 100, nullable = false)
    private String nombres;

    @Column(name = "direccion", length = 100)
    private String direccion;

    @Column(name = "fNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fNacimiento;

    @Column(name = "sexo", length = 50)
    private String sexo;

    @Column(name = "correo", length = 100)
    private String correo;

    @Column(name = "password", length = 25)
    private String password;

    @Column(name = "estado", length = 100)
    private String estado;
}
