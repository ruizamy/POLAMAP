package com.ecommerce.backend.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="rol")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;
    @Column(name = "nombreRol")
    private String nombreRol;
}
