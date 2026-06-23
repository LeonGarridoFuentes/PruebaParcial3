package com.Inmobiliaria.demo.direccion.service;

import com.Inmobiliaria.demo.cliente.model.Cliente;
import com.Inmobiliaria.demo.cliente.service.ClienteService;
import com.Inmobiliaria.demo.direccion.model.Direccion;
import com.Inmobiliaria.demo.direccion.repository.DireccionRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DireccionService {


    @Autowired
    private DireccionRepository direccionRepository;


    public List<Direccion> findAll() {
        return direccionRepository.findAll();
    }

    public Direccion save(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    public Direccion findById(Long id) {
        return direccionRepository.findById(id).orElse(null);
    }

    public boolean delete(Long id) {
        if (direccionRepository.existsById(id)) {
            direccionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}