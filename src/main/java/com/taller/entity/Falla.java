package com.taller.entity;



import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "fallas")
public class Falla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String severidad;

    @Column(nullable = false)
    private Double tiempoEstimadoReparacion;
}