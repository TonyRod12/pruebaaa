package com.taller.controller;

import com.taller.entity.Facturacion;
import com.taller.service.FacturacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/facturas")
public class FacturacionController {

    private final FacturacionService facturacionService;

    public FacturacionController(FacturacionService facturacionService) {
        this.facturacionService = facturacionService;
    }

    @PostMapping("/reparacion/{reparacionId}")
    public ResponseEntity<Facturacion> generarFactura(
            @PathVariable Long reparacionId,
            @RequestParam Double monto) {
        return ResponseEntity.ok(facturacionService.generarFactura(reparacionId, monto));
    }
}