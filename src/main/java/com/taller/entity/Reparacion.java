package com.taller.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "Reparacion")
public class Reparacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "auto_id", nullable = false)
    private Auto auto;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaIngreso;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;

    @Column(nullable = false)
    private String estado; // En diagnóstico, En reparación, Finalizada

    @ManyToMany
    @JoinTable(
            name = "reparacion_fallas",
            joinColumns = @JoinColumn(name = "idReparacion"),
            inverseJoinColumns = @JoinColumn(name = "idFalla"))

    private List<Falla> fallas;

    @OneToOne(mappedBy = "reparacion", cascade = CascadeType.ALL)
    private Facturacion facturacion;
}