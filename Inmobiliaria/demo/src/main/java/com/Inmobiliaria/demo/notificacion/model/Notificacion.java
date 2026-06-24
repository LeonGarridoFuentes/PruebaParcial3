package com.Inmobiliaria.demo.notificacion.model;

import com.Inmobiliaria.demo.cliente.model.Cliente;
import com.Inmobiliaria.demo.reclamo.model.Reclamo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// Cambiado a LocalDate para manejar solo la fecha (sin hora)
import java.time.LocalDate;

@Entity
@Table(name = "notificaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String mensaje;

    private boolean leido = false;

    private LocalDate fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "reclamo_id", nullable = true)
    private Reclamo reclamo;

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDate.now();
    }
}