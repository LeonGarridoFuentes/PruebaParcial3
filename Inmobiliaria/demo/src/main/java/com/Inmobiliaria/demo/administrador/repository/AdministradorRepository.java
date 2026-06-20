package com.Inmobiliaria.demo.administrador.repository;

import com.Inmobiliaria.demo.administrador.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
}