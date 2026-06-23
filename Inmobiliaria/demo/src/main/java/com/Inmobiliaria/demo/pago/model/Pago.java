package com.Inmobiliaria.demo.pago.model;

import com.Inmobiliaria.demo.cliente.model.Cliente;
import com.Inmobiliaria.demo.propiedad.model.Propiedad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;

@Entity
@Table(name = "pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private LocalDateTime fechaPago;

    @Column(nullable = false)
    @NotNull
    private String metodoPago;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @NotNull
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "propiedad_id", nullable = false)
    @NotNull
    private Propiedad propiedad;
}