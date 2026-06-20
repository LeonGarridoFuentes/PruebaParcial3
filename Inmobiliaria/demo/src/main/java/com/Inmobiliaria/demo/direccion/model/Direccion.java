package com.Inmobiliaria.demo.direccion.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "direccion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String region;

    @Column(nullable = false)
    @NotBlank
    private String comuna;

    @Column(nullable = true)
    private String calle; //

    @Column(nullable = false)
    @NotNull
    private Integer numero; //
}