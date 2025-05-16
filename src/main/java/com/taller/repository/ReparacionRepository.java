package com.taller.repository;

import com.taller.entity.Reparacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Repositorio para manejar operaciones CRUD de reparaciones
 */
@Repository
public interface ReparacionRepository extends JpaRepository<Reparacion, Long> {

}