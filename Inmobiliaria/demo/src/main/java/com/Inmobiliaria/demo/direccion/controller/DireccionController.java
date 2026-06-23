package com.Inmobiliaria.demo.direccion.controller;

import com.Inmobiliaria.demo.cliente.model.Cliente;
import com.Inmobiliaria.demo.direccion.model.Direccion;
import com.Inmobiliaria.demo.direccion.service.DireccionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/direcciones")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    @GetMapping
    public ResponseEntity<List<Direccion>> listar() {
        List<Direccion> direccions = direccionService.findAll();
        if (direccions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(direccions);
    }

    @PostMapping
    public ResponseEntity<Direccion> crear(@Valid @RequestBody Direccion direccion) {
        Direccion nueva = direccionService.save(direccion);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direccion> obtenerPorId(@PathVariable Long id) {
        Direccion direccion = direccionService.findById(id);
        if (direccion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(direccion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direccion> editarPorId(@PathVariable Long id, @Valid @RequestBody Direccion direccion) {
        Direccion direccionExistente = direccionService.findById(id);
        if (direccionExistente == null) {
            return ResponseEntity.notFound().build();
        }
        direccion.setId(id);
        Direccion editada = direccionService.save(direccion);
        return ResponseEntity.ok(editada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        if (direccionService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}