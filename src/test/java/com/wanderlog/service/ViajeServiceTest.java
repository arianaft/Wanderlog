package com.wanderlog.service;

import com.wanderlog.exception.ViajeNotFoundException;
import com.wanderlog.model.Viaje;
import com.wanderlog.repository.ViajeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ViajeServiceTest {

    @Mock
    ViajeRepository repository;

    @InjectMocks
    ViajeService servicio;

    @Test
    void obtenerTodosViajes_debeRetornarLista() {

        // Arrange
        Viaje viaje = new Viaje();
        viaje.setTitulo("Viaje a París");
        when(repository.findAll()).thenReturn(List.of(viaje));

        // Act
        List<Viaje> resultado = servicio.obtenerTodosViajes();


        // Assert
        assertEquals(1, resultado.size());
        assertEquals("Viaje a París", resultado.get(0).getTitulo());
    }

    @Test
    void buscarViajeId_idInexistente_lanzaException(){

        //Arrange
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ViajeNotFoundException.class, () -> servicio.buscarViajeId(99L));
    }
}
