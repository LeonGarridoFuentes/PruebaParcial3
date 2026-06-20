package com.Inmobiliaria.demo.reclamo.repository;

import com.Inmobiliaria.demo.reclamo.model.Reclamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamoRepository extends JpaRepository<Reclamo, Long> {
}