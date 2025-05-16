package com.taller.service;

import com.taller.entity.*;
import com.taller.repository.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReparacionService {

    private final ReparacionRepository reparacionRepository;
    private final AutoRepository autoRepository;
    private final FallaRepository fallaRepository;

    public ReparacionService(ReparacionRepository reparacionRepository,
                             AutoRepository autoRepository,
                             FallaRepository fallaRepository) {
        this.reparacionRepository = reparacionRepository;
        this.autoRepository = autoRepository;
        this.fallaRepository = fallaRepository;
    }

    public Reparacion iniciarReparacion(Long autoId, List<Long> fallasIds) {
        Auto auto = autoRepository.findById(autoId)
                .orElseThrow(() -> new RuntimeException("Auto no encontrado"));

        List<Falla> fallas = fallaRepository.findAllById(fallasIds);

        Reparacion reparacion = new Reparacion();
        reparacion.setAuto(auto);
        reparacion.setFechaIngreso(new Date());
        reparacion.setEstado("EN_REPARACION");
        reparacion.setFallas(fallas);

        return reparacionRepository.save(reparacion);
    }
}