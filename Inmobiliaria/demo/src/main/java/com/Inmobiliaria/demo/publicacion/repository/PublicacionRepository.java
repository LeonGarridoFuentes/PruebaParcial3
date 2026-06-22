package com.Inmobiliaria.demo.publicacion.repository;

import com.Inmobiliaria.demo.publicacion.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
}