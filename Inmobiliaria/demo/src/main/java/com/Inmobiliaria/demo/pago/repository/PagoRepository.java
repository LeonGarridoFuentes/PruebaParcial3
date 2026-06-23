package com.Inmobiliaria.demo.pago.repository;

import com.Inmobiliaria.demo.pago.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
}