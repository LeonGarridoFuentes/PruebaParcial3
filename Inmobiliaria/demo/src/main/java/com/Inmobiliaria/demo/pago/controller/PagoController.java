package com.Inmobiliaria.demo.pago.controller;

import com.Inmobiliaria.demo.pago.model.Pago;
import com.Inmobiliaria.demo.pago.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @PostMapping
    public ResponseEntity<Pago> crearPago(@RequestBody Pago pago) {
        Pago nuevoPago = pagoService.guardarPago(pago);
        return new ResponseEntity<>(nuevoPago, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pago>> listarPagos() {
        List<Pago> pagos = pagoService.obtenerTodosLosPagos();
        return new ResponseEntity<>(pagos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> buscarPorId(@PathVariable Long id) {
        return pagoService.obtenerPagoPorId(id)
                .map(pago -> new ResponseEntity<>(pago, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        boolean eliminado = pagoService.eliminarPagoPorId(id);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}