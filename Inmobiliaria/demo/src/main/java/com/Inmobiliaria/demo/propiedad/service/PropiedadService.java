
package com.Inmobiliaria.demo.propiedad.service;

import com.Inmobiliaria.demo.propiedad.model.Propiedad;
import com.Inmobiliaria.demo.propiedad.repository.PropiedadRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PropiedadService {

    @Autowired
    private PropiedadRepository propiedadRepository;

    public List<Propiedad> findAll() {
        return propiedadRepository.findAll();
    }


    public Optional<Propiedad> findById(Long id) {
        return propiedadRepository.findById(id);
    }

    public Propiedad save(Propiedad propiedad) {
        return propiedadRepository.save(propiedad);
    }

    public boolean deleteById(Long id) {
        if (propiedadRepository.existsById(id)) {
            propiedadRepository.deleteById(id);
            return true;
        }
        return false;
    }
}