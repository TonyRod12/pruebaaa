package com.taller.controller;

import com.taller.entity.Auto;
import com.taller.service.AutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autos")
public class AutoController {

    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @PostMapping("/cliente/{clienteId}")
    public ResponseEntity<Auto> registrarAuto(
            @PathVariable Long clienteId,
            @RequestBody Auto auto) {
        return ResponseEntity.ok(autoService.registrarAuto(auto, clienteId));
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Auto> listarAutosPorCliente(@PathVariable Long clienteId) {
        return autoService.listarAutosPorCliente(clienteId);
    }
}