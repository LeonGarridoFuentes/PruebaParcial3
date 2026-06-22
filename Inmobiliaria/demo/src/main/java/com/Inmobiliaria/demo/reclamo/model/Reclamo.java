package com.Inmobiliaria.demo.reclamo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "reclamo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    @NotBlank
    private String motivo;

    @Column(nullable = false)
    @NotBlank
    private String descripcion;

    @Column(nullable = false)
    @NotBlank
    private String estado;

    private LocalDateTime fechaReclamo;

    @PrePersist
    protected void onCreate() {
        fechaReclamo = LocalDateTime.now();
    }
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private com.Inmobiliaria.demo.cliente.model.Cliente cliente;
}