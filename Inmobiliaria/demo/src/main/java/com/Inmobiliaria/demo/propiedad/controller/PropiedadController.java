package com.Inmobiliaria.demo.propiedad.controller;

import com.Inmobiliaria.demo.propiedad.model.Propiedad;
import com.Inmobiliaria.demo.propiedad.service.PropiedadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/propiedades")
public class PropiedadController {

    @Autowired
    private PropiedadService propiedadService;

    @PostMapping
    public ResponseEntity<Propiedad> crear(@Valid @RequestBody Propiedad propiedad) {
        Propiedad nueva = propiedadService.save(propiedad);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propiedad> findById(@PathVariable Long id) {
        return propiedadService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (propiedadService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}