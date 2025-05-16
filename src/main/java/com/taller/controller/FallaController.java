package com.taller.controller;

import com.taller.entity.Falla;
import com.taller.service.FallaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fallas")
public class FallaController {

    private final FallaService fallaService;

    public FallaController(FallaService fallaService) {
        this.fallaService = fallaService;
    }

    @PostMapping
    public Falla registrarFalla(@RequestBody Falla falla) {
        return fallaService.registrarFalla(falla);
    }

    @GetMapping("/severidad/{severidad}")
    public List<Falla> buscarPorSeveridad(@PathVariable String severidad) {
        return fallaService.buscarFallasPorSeveridad(severidad);
    }


}