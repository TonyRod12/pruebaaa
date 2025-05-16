package com.taller.service;

import com.taller.entity.Cliente;
import com.taller.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClienteService {

    private final ClienteRepository clienteRepository;

    // Inyección de dependencia (no uses @Autowired explícito)
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // CREATE
    public Cliente crearCliente(Cliente cliente) {
        if (clienteRepository.existsByDni(cliente.getDni())) {
            throw new RuntimeException("El DNI ya está registrado");
        }
        return clienteRepository.save(cliente);
    }

    // READ
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    // UPDATE
    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
        Cliente clienteExistente = buscarPorId(id);
        clienteExistente.setNombre(clienteActualizado.getNombre());
        clienteExistente.setTelefono(clienteActualizado.getTelefono());
        return clienteRepository.save(clienteExistente);
    }

    // DELETE
    public void eliminarCliente(Long id) {
        Cliente cliente = buscarPorId(id);
        if (!cliente.getAutos().isEmpty()) {
            throw new RuntimeException("No se puede eliminar, el cliente tiene autos registrados");
        }
        clienteRepository.delete(cliente);
    }
}