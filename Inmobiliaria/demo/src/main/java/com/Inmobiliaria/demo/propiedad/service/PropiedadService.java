
package com.Inmobiliaria.demo.propiedad.service;

import com.Inmobiliaria.demo.propiedad.model.Propiedad;
import com.Inmobiliaria.demo.propiedad.repository.PropiedadRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Transactional
public class PropiedadService {

    @Autowired
    private PropiedadRepository propiedadRepository;

    public Optional<Propiedad> findById(Long id) {
        return propiedadRepository.findById(id);
    }

    public Optional<Propiedad> findByIdAndEstado(Long id, boolean estado) {
        return propiedadRepository.findByIdAndEstado(id, estado);
    }

    public Optional<Propiedad> findByIdAndUbicacion(Long id, String ubicacion) {
        return propiedadRepository.findByIdAndUbicacionIgnoreCase(id, ubicacion);
    }

    public Propiedad save(Propiedad propiedad) {
        return propiedadRepository.save(propiedad);
    }

    public boolean delete(Long id) {
        if (propiedadRepository.existsById(id)) {
            propiedadRepository.deleteById(id);
            return true;
        }
        return false;
    }
}