package com.Inmobiliaria.demo.notificacion.repository;

import com.Inmobiliaria.demo.notificacion.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

    List<Notificacion> findByClienteId(Long clienteId);

    List<Notificacion> findByClienteIdAndLeidoFalse(Long clienteId);

}