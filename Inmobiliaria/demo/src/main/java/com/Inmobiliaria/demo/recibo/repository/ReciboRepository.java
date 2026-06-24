package com.Inmobiliaria.demo.recibo.repository;

import com.Inmobiliaria.demo.recibo.model.Recibo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReciboRepository extends JpaRepository<Recibo, Long> {
}