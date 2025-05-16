package com.taller.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "clientes")  // ← Español y plural
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(unique = true, nullable = false)
    private String dni;

    private String telefono;
    private String direccion;  // ← Corregido a español

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Auto> autos;
}