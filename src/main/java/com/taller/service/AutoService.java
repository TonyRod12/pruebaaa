package com.taller.service;

import com.taller.entity.Auto;
import com.taller.entity.Cliente;
import com.taller.repository.AutoRepository;
import com.taller.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoService {

    private final AutoRepository autoRepository;
    private final ClienteRepository clienteRepository;

    public AutoService(AutoRepository autoRepository, ClienteRepository clienteRepository) {
        this.autoRepository = autoRepository;
        this.clienteRepository = clienteRepository;
    }

    public Auto registrarAuto(Auto auto, Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        auto.setCliente(cliente);
        return autoRepository.save(auto);
    }

    public List<Auto> listarAutosPorCliente(Long clienteId) {
        return autoRepository.findByClienteId(clienteId);
    }
}