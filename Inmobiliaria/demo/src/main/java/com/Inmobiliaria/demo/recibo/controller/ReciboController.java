package com.Inmobiliaria.demo.recibo.controller;

import com.Inmobiliaria.demo.recibo.model.Recibo;
import com.Inmobiliaria.demo.recibo.service.ReciboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recibos")
public class ReciboController {

    @Autowired
    private ReciboService reciboService;

    @PostMapping
    public ResponseEntity<Recibo> crearRecibo(@RequestBody Recibo recibo) {
        Recibo nuevoRecibo = reciboService.guardarRecibo(recibo);
        return new ResponseEntity<>(nuevoRecibo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Recibo>> listarRecibos() {
        List<Recibo> recibos = reciboService.obtenerTodosLosRecibos();
        return new ResponseEntity<>(recibos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recibo> buscarPorId(@PathVariable Long id) {
        return reciboService.obtenerReciboPorId(id)
                .map(recibo -> new ResponseEntity<>(recibo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        boolean eliminado = reciboService.eliminarReciboPorId(id);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}