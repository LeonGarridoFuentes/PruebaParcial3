package com.Inmobiliaria.demo.recibo.model;

import com.Inmobiliaria.demo.cliente.model.Cliente;
import com.Inmobiliaria.demo.pago.model.Pago;
import com.Inmobiliaria.demo.propiedad.model.Propiedad;
import com.Inmobiliaria.demo.corredor.model.Corredor;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "recibo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recibo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numeroRecibo;

    private LocalDate fechaEmision;

    @OneToOne
    @JoinColumn(name = "pago_id", nullable = false, unique = true)
    private Pago pago;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "propiedad_id", nullable = false)
    private Propiedad propiedad;

    @ManyToOne
    @JoinColumn(name = "corredor_id", nullable = false)
    private Corredor corredor; //

    @PrePersist
    protected void onCreate() {
        this.fechaEmision = LocalDate.now();
    }
}