package com.Inmobiliaria.demo.publicacion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import com.Inmobiliaria.demo.corredor.model.Corredor;
import com.Inmobiliaria.demo.propiedad.model.Propiedad;

@Entity
@Table(name = "publicaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "corredor_id", nullable = false)
    private Corredor corredor;

    @ManyToOne
    @JoinColumn(name = "propiedad_id", nullable = false)
    private Propiedad propiedad;
}