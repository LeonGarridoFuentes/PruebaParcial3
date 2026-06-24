package com.Inmobiliaria.demo.recibo.service;

import com.Inmobiliaria.demo.recibo.model.Recibo;
import com.Inmobiliaria.demo.recibo.repository.ReciboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReciboService {

    @Autowired
    private ReciboRepository reciboRepository;

    public Recibo guardarRecibo(Recibo recibo) {
        return reciboRepository.save(recibo);
    }

    public List<Recibo> obtenerTodosLosRecibos() {
        return reciboRepository.findAll();
    }

    public Optional<Recibo> obtenerReciboPorId(Long id) {
        return reciboRepository.findById(id);
    }

    public boolean eliminarReciboPorId(Long id) {
        if (reciboRepository.existsById(id)) {
            reciboRepository.deleteById(id);
            return true;
        }
        return false;
    }
}