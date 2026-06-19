package com.Inmobiliaria.demo.cliente.service;

import com.Inmobiliaria.demo.cliente.model.Cliente;
import com.Inmobiliaria.demo.cliente.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class ClienteService {

    private static final Logger log = LoggerFactory.getLogger(ClienteService.class);

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        log.info("Buscando todos los clientes");
        return clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente) {
        log.info("Guardando nuevo cliente");
        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        log.info("Eliminando cliente por ID: {}", id);
        if (!clienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente", id);
        }
        clienteRepository.deleteById(id);
    }

    public Cliente findById(Long id) {
        log.info("Buscando cliente por ID: {}", id);
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", id));
    }
}