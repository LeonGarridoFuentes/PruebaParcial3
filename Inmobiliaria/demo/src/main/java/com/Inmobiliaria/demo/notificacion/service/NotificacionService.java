package com.Inmobiliaria.demo.notificacion.service;

import com.Inmobiliaria.demo.cliente.model.Cliente;
import com.Inmobiliaria.demo.cliente.repository.ClienteRepository;
import com.Inmobiliaria.demo.notificacion.model.Notificacion;
import com.Inmobiliaria.demo.notificacion.repository.NotificacionRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class NotificacionService {

    private static final Logger log = LoggerFactory.getLogger(NotificacionService.class);

    @Autowired
    private NotificacionRepository notificacionRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Notificacion> findAll() {
        return notificacionRepository.findAll();
    }

    public List<Notificacion> findByCliente(Long clienteId) {
        return notificacionRepository.findByClienteId(clienteId);
    }

    public List<Notificacion> findNoLeidas(Long clienteId) {
        return notificacionRepository.findByClienteIdAndLeidoFalse(clienteId);
    }

    public Notificacion save(Notificacion notificacion) {
        log.info("Creando notificación");

        if (notificacion.getCliente() == null || notificacion.getCliente().getId() == null) {
            throw new IllegalArgumentException("Debe especificar un cliente para la notificación");
        }

        Cliente clienteDB = clienteRepository.findById(notificacion.getCliente().getId())
                .orElseThrow(() -> new NoSuchElementException("Cliente no encontrado con el ID: " + notificacion.getCliente().getId()));

        notificacion.setCliente(clienteDB);

        return notificacionRepository.save(notificacion);
    }

    public void marcarComoLeida(Long id) {
        Notificacion notificacion = notificacionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Notificacion no encontrada con el ID: " + id));

        notificacion.setLeido(true);

        notificacionRepository.save(notificacion);
    }
}