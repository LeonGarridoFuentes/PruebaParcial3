package com.Inmobiliaria.demo.corredor.controller;

import com.Inmobiliaria.demo.corredor.model.Corredor;
import com.Inmobiliaria.demo.corredor.service.CorredorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1corredores")//hola
public class CorredorController {

    @Autowired
    private CorredorService corredorService;

    @GetMapping
    public List<Corredor> getAll() {
        return corredorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Corredor> getById(@PathVariable Long id) {
        return ResponseEntity.ok(corredorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Corredor> create(@RequestBody Corredor corredor) {
        return ResponseEntity.ok(corredorService.save(corredor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        corredorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}