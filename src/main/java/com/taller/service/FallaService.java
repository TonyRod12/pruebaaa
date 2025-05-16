package com.taller.service;

import com.taller.entity.Falla;
import com.taller.repository.FallaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FallaService {

    private final FallaRepository fallaRepository;

    public FallaService(FallaRepository fallaRepository) {
        this.fallaRepository = fallaRepository;
    }

    public Falla registrarFalla(Falla falla) {
        return fallaRepository.save(falla);
    }

    public List<Falla> buscarFallasPorSeveridad(String severidad) {
        return fallaRepository.findBySeveridad(severidad);
    }
}