package com.taller.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "facturas")
public class Facturacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "idReparacion", nullable = false)
    private Reparacion reparacion;

    @Column(nullable = false)
    private Double montoTotal;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaEmision;

    @Column(nullable = false)
    private String estadoPago; // Pendiente, Pagado

    private String detalles;
}