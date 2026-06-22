package com.Inmobiliaria.demo.publicacion.controller;

import com.Inmobiliaria.demo.publicacion.model.Publicacion;
import com.Inmobiliaria.demo.publicacion.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    @GetMapping
    public ResponseEntity<List<Publicacion>> listar() {
        List<Publicacion> lista = publicacionService.findAll();
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<Publicacion> guardar(@RequestBody Publicacion publicacion) {
        if (publicacion.getFechaPublicacion() == null) {
            publicacion.setFechaPublicacion(LocalDateTime.now());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(publicacionService.save(publicacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        publicacionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}