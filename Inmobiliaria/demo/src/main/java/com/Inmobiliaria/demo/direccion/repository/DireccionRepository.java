package com.Inmobiliaria.demo.direccion.repository;

import com.Inmobiliaria.demo.direccion.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
}