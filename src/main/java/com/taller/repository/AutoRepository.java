package com.taller.repository;

import com.taller.entity.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long> {

    // Método para buscar autos por cliente
    List<Auto> findByClienteId(Long clienteId);

}