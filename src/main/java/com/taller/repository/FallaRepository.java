package com.taller.repository;

import com.taller.entity.Falla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para manejar operaciones CRUD de fallas
 */
@Repository
public interface FallaRepository extends JpaRepository<Falla, Long> {
    // Método para buscar fallas por severidad
    List<Falla> findBySeveridad(String severidad);
}