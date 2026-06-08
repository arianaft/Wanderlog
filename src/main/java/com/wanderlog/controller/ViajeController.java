package com.wanderlog.controller;

import com.wanderlog.model.Viaje;
import com.wanderlog.service.ViajeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/viajes")
@Tag(name = "Viajes", description = "Gestión de viajes del diario")
@SecurityRequirement(name = "bearerAuth")
public class ViajeController {

    @Autowired
    private ViajeService servicio;

    @GetMapping
    @Operation(summary = "Obtener todos los viajes")
    public List<Viaje> ObtenerTodosViaje() {
        return servicio.obtenerTodosViajes();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un viaje por ID")
    public Viaje obtenerPorId(@PathVariable Long id) {
        return servicio.buscarViajeId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un nuevo viaje")
    public Viaje crear(@RequestBody @Valid Viaje viaje) {
        return servicio.guardarViaje(viaje);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un viaje existente")
    public Viaje actualizar(@PathVariable Long id, @RequestBody Viaje viaje) {
        return servicio.actualizarViaje(id, viaje);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Eliminar un viaje")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminarViaje(id);
    }
}
