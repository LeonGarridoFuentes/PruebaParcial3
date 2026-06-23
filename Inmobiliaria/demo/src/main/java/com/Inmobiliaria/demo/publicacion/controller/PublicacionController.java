package com.Inmobiliaria.demo.publicacion.controller;

import com.Inmobiliaria.demo.direccion.model.Direccion;
import com.Inmobiliaria.demo.publicacion.model.Publicacion;
import com.Inmobiliaria.demo.publicacion.service.PublicacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;


    @PostMapping
    public ResponseEntity<Publicacion> crear(@Valid @RequestBody Publicacion publicacion) {
        Publicacion nueva = publicacionService.save(publicacion);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Publicacion>> listar() {
        List<Publicacion> lista = publicacionService.findAll();
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPorId(@PathVariable Long id) {
        Publicacion publicacion = publicacionService.findById(id);
        if (publicacion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(publicacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        publicacionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}