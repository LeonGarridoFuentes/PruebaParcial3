package com.Inmobiliaria.demo.propiedad.repository;

import com.Inmobiliaria.demo.propiedad.model.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PropiedadRepository extends JpaRepository<Propiedad, Long> {

    Optional<Propiedad> findByIdAndEstado(Long id, boolean estado);

    boolean existsByIdAndEstado(Long id, boolean estado);
}
