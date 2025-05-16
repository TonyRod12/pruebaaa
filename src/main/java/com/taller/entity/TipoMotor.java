package com.taller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TipoMotor")

public class TipoMotor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  idTipoMotor;

    @Column(columnDefinition = "VARCHAR(20)")
    private String Tipo;

    @Column(columnDefinition = "DECIMAL(3, 1)")
    private String Cilindrada;

    @Column(columnDefinition = "DECIMAL(6, 2)")
    private String Potencia;

}
