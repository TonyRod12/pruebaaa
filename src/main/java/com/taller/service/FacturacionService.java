package com.taller.service;

import com.taller.entity.Facturacion;
import com.taller.entity.Reparacion;
import com.taller.repository.FacturacionRepository;
import com.taller.repository.ReparacionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FacturacionService {

    private final FacturacionRepository facturacionRepository;
    private final ReparacionRepository reparacionRepository;

    public FacturacionService(FacturacionRepository facturacionRepository,
                              ReparacionRepository reparacionRepository) {
        this.facturacionRepository = facturacionRepository;
        this.reparacionRepository = reparacionRepository;
    }

    public Facturacion generarFactura(Long reparacionId, Double monto) {
        Reparacion reparacion = reparacionRepository.findById(reparacionId)
                .orElseThrow(() -> new RuntimeException("Reparación no encontrada"));

        Facturacion factura = new Facturacion();
        factura.setReparacion(reparacion);
        factura.setMontoTotal(monto);
        factura.setFechaEmision(new Date());
        factura.setEstadoPago("PENDIENTE");

        return facturacionRepository.save(factura);
    }
}