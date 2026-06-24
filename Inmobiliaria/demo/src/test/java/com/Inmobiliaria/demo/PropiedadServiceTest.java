package com.Inmobiliaria.demo;

import com.Inmobiliaria.demo.direccion.model.Direccion;
import com.Inmobiliaria.demo.propiedad.model.Propiedad;
import com.Inmobiliaria.demo.propiedad.repository.PropiedadRepository;
import com.Inmobiliaria.demo.propiedad.service.PropiedadService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PropiedadServiceTest {

    @Mock
    private PropiedadRepository propiedadRepository;

    @InjectMocks
    private PropiedadService propiedadService;

    @Test
    public void buscarPropiedadPorId_DeberiaRetornarPropiedad_CuandoExiste() {

        Long idPrueba = 1L;

        Propiedad propiedadFalsa = new Propiedad();
        propiedadFalsa.setId(idPrueba);

        Direccion direccionFalsa = new Direccion();
        propiedadFalsa.setDireccion(direccionFalsa);

        Mockito.when(propiedadRepository.findById(idPrueba)).thenReturn(Optional.of(propiedadFalsa));

        Optional<Propiedad> resultado = propiedadService.findById(idPrueba);
        assertTrue(resultado.isPresent(), "El resultado debería contener una propiedad");
        assertNotNull(resultado.get().getDireccion(), "La relación con Dirección no debe perderse");

        Mockito.verify(propiedadRepository, Mockito.times(1)).findById(idPrueba);
    }
}