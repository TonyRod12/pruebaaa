package com.taller.repository;

import com.taller.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para manejar operaciones CRUD de clientes
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Método para buscar cliente por DNI
    Cliente findByDni(String dni);

    // Método para verificar existencia por DNI
    boolean existsByDni(String dni);
}