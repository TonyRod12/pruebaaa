package com.taller.controller;

import com.taller.entity.Reparacion;
import com.taller.service.ReparacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reparaciones")
public class ReparacionController {

    private final ReparacionService reparacionService;

    public ReparacionController(ReparacionService reparacionService) {
        this.reparacionService = reparacionService;
    }

    @PostMapping("/auto/{autoId}")
    public ResponseEntity<Reparacion> iniciarReparacion(
            @PathVariable Long autoId,
            @RequestBody List<Long> fallasIds) {
        return ResponseEntity.ok(reparacionService.iniciarReparacion(autoId, fallasIds));
    }
}