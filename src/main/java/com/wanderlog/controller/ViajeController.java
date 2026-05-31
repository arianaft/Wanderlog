package com.wanderlog.controller;

import com.wanderlog.model.Viaje;
import com.wanderlog.service.ViajeService;
import org.apache.coyote.Request;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Viaje crear(@RequestBody Viaje viaje){
        return  servicio.guardarViaje(viaje);
    }

    @PutMapping("/{id}")
    public  Viaje actualizar(@PathVariable Long id, @RequestBody Viaje viaje){
        return servicio.actualizarViaje(id, viaje);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        servicio.eliminarViaje(id);
    }

}
