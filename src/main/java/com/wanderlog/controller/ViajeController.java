package com.wanderlog.controller;

import com.wanderlog.model.Viaje;
import com.wanderlog.service.ViajeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/viajes")

public class ViajeController {
    private ViajeService servicio  = new ViajeService();

    @GetMapping

    public List<Viaje> ObtenerTodosViaje(){
        return servicio.obtenerTodosViajes();

    }

}
