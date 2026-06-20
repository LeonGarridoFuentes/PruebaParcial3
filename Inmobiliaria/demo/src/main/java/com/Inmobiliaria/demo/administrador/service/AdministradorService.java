package com.Inmobiliaria.demo.administrador.service;

import com.Inmobiliaria.demo.administrador.model.Administrador;
import com.Inmobiliaria.demo.administrador.repository.AdministradorRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class AdministradorService {

    private static final Logger log = LoggerFactory.getLogger(AdministradorService.class);

    @Autowired
    private AdministradorRepository administradorRepository;

    public List<Administrador> findAll() {
        log.info("Obteniendo lista de todos los administradores");
        return administradorRepository.findAll();
    }

    public Administrador findById(Long id) {
        log.info("Buscando administrador con ID: {}", id);
        return administradorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Administrador no encontrado con el ID: " + id));
    }

    public Administrador save(Administrador administrador) {
        log.info("Registrando un nuevo administrador");
        if (administrador.getEmail() == null || administrador.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El email del administrador no puede estar vacío");
        }
        return administradorRepository.save(administrador);
    }

    public void delete(Long id) {
        log.info("Eliminando administrador con ID: {}", id);
        Administrador administrador = findById(id);
        administradorRepository.delete(administrador);
    }
}