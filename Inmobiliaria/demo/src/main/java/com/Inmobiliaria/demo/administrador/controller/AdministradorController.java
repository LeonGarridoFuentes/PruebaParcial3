package com.Inmobiliaria.demo.administrador.controller;

import com.Inmobiliaria.demo.administrador.model.Administrador;
import com.Inmobiliaria.demo.administrador.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping
    public List<Administrador> getAll() {
        return administradorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrador> getById(@PathVariable Long id) {
        return ResponseEntity.ok(administradorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Administrador> create(@RequestBody Administrador administrador) {
        return ResponseEntity.ok(administradorService.save(administrador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        administradorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}