package com.Inmobiliaria.demo.reclamo.controller;

import com.Inmobiliaria.demo.reclamo.model.Reclamo;
import com.Inmobiliaria.demo.reclamo.service.ReclamoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reclamos")
public class ReclamoController {

    @Autowired
    private ReclamoService reclamoService;

    @GetMapping
    public ResponseEntity<List<Reclamo>> listar() {
        List<Reclamo> reclamo = reclamoService.findAll();
        if (reclamo.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reclamo);
    }

    @PostMapping
    public ResponseEntity<Reclamo> guardar(@Valid @RequestBody Reclamo reclamo) {
        Reclamo reclamoNuevo = reclamoService.save(reclamo);
        return ResponseEntity.status(HttpStatus.CREATED).body(reclamoNuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reclamo> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(reclamoService.findById(id));
    }
}
