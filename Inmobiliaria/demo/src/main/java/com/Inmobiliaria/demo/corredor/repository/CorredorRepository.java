package com.Inmobiliaria.demo.corredor.repository;

import com.Inmobiliaria.demo.corredor.model.Corredor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorredorRepository extends JpaRepository<Corredor, Long> {
}