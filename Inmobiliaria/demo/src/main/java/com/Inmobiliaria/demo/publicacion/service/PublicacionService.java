package com.Inmobiliaria.demo.publicacion.service;

import com.Inmobiliaria.demo.publicacion.model.Publicacion;
import com.Inmobiliaria.demo.publicacion.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepository;

    public List<Publicacion> findAll() {
        return publicacionRepository.findAll();
    }

    public Publicacion save(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    public void delete(Long id) {
        publicacionRepository.deleteById(id);
    }
}