package com.Inmobiliaria.demo;

import com.Inmobiliaria.demo.pago.model.Pago;
import com.Inmobiliaria.demo.pago.repository.PagoRepository;
import com.Inmobiliaria.demo.pago.service.PagoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PagoServiceTest {

    @Mock
    private PagoRepository pagoRepository;

    @InjectMocks
    private PagoService pagoService;

    @Test
    public void buscarPagoPorId_DeberiaRetornarPago_CuandoExiste() {
        Long idPrueba = 1L;

        Pago pagoFalso = new Pago();
        pagoFalso.setId(idPrueba);

        Mockito.when(pagoRepository.findById(idPrueba)).thenReturn(Optional.of(pagoFalso));

        Optional<Pago> resultado = pagoService.obtenerPagoPorId(idPrueba);

        assertTrue(resultado.isPresent(), "El pago debería ser encontrado");
        assertEquals(idPrueba, resultado.get().getId(), "El ID del pago debe coincidir");

        Mockito.verify(pagoRepository, Mockito.times(1)).findById(idPrueba);
    }
}