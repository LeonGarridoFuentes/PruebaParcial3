package com.Inmobiliaria.demo.corredor.service;

import com.Inmobiliaria.demo.corredor.model.Corredor;
import com.Inmobiliaria.demo.corredor.repository.CorredorRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class CorredorService {

    private static final Logger log = LoggerFactory.getLogger(CorredorService.class);

    @Autowired
    private CorredorRepository corredorRepository;

    public List<Corredor> findAll() {
        log.info("Obteniendo todos los corredores de propiedades");
        return corredorRepository.findAll();
    }

    public Corredor findById(Long id) {
        log.info("Buscando corredor por ID: {}", id);
        return corredorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Corredor no encontrado con el ID: " + id));
    }

    public Corredor save(Corredor corredor) {
        log.info("Registrando un nuevo corredor de propiedades");
        if (corredor.getEmail() == null || corredor.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El email del corredor es obligatorio");
        }
        return corredorRepository.save(corredor);
    }

    public void delete(Long id) {
        log.info("Eliminando corredor con ID: {}", id);
        Corredor corredor = findById(id);
        corredorRepository.delete(corredor);
    }
}