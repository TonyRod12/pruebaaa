package com.taller.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "Auto")
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuto;

    @Column(nullable = false)
    private String Marca;

    @Column(nullable = false)
    private String Modelo;

    @Column(nullable = false)
    private String NumeroSerie;

    @Enumerated(EnumType.STRING)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoMotor")
    private TipoMotor tipoMotor;
}