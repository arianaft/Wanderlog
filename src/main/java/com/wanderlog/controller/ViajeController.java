package com.wanderlog.controller;

import com.wanderlog.model.Viaje;
import com.wanderlog.service.ViajeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viajes")

public class ViajeController {

    @Autowired
    private ViajeService servicio;


    @GetMapping

    public List<Viaje> ObtenerTodosViaje(){
        return servicio.obtenerTodosViajes();

    }

    @GetMapping("/{id}")
    public Viaje obtenerPorId(@PathVariable Long id){
        return servicio.buscarViajeId(id);
    }


    //Guarda
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Viaje crear(@RequestBody  @Valid Viaje viaje){
        return  servicio.guardarViaje(viaje);
    }

    //Actualiza
    @PutMapping("/{id}")
    public  Viaje actualizar(@PathVariable Long id, @RequestBody Viaje viaje){
        return servicio.actualizarViaje(id, viaje);
    }

    //Elimina
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        servicio.eliminarViaje(id);
    }

}
