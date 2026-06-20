package com.Inmobiliaria.demo.reclamo.service;

import com.Inmobiliaria.demo.cliente.model.Cliente;
import com.Inmobiliaria.demo.cliente.repository.ClienteRepository;
import com.Inmobiliaria.demo.reclamo.model.Reclamo;
import com.Inmobiliaria.demo.reclamo.repository.ReclamoRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class ReclamoService {

    private static final Logger log = LoggerFactory.getLogger(ReclamoService.class);

    @Autowired
    private ReclamoRepository reclamoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Reclamo> findAll() {
        log.info("Buscando todos los reclamos");
        return reclamoRepository.findAll();
    }

    public Reclamo save(Reclamo reclamo) {
        log.info("Registrando nuevo reclamo asignado a un cliente");


        if (reclamo.getCliente() == null || reclamo.getCliente().getId() == null) {
            throw new IllegalArgumentException("Debe especificar un cliente válido para registrar el reclamo");
        }

        Cliente clienteDB = clienteRepository.findById(reclamo.getCliente().getId())
                .orElseThrow(() -> new NoSuchElementException("Cliente no encontrado con el ID: " + reclamo.getCliente().getId()));
        reclamo.setCliente(clienteDB);

        if (reclamo.getEstado() == null) {
            reclamo.setEstado("PENDIENTE");
        }

        return reclamoRepository.save(reclamo);
    }

    public Reclamo findById(Long id) {
        log.info("Buscando reclamo por ID: {}", id);
        return reclamoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Reclamo no encontrado con el ID: " + id));
    }
}