package com.taller.repository;

import com.taller.entity.Facturacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para manejar operaciones CRUD de facturaciones
 */
@Repository
public interface FacturacionRepository extends JpaRepository<Facturacion, Long> {

}