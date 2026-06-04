package com.wanderlog.service;

import com.wanderlog.exception.ViajeNotFoundException;
import com.wanderlog.model.Viaje;
import com.wanderlog.repository.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ViajeService {

    @Autowired
    private ViajeRepository repositorio;

    //Guarda viajes

    public Viaje guardarViaje(Viaje viaje) {

        return repositorio.save(viaje);
    }

    //Devuelve todos los viajes

    public List<Viaje> obtenerTodosViajes(){
        return repositorio.findAll();
    }

    //Buscar por id

    public Viaje buscarViajeId(Long id){
        return repositorio.findById(id).orElseThrow(() -> new ViajeNotFoundException(id));
    }

    public Viaje actualizarViaje(Long id, Viaje datos){
        Viaje existente = buscarViajeId(id);
        existente.setTitulo(datos.getTitulo());
        existente.setDescripcion(datos.getDescripcion());
        existente.setFechaInicio(datos.getFechaInicio());
        existente.setFechaFin(datos.getFechaFin());
        existente.setVisibilidad(datos.getVisibilidad());
        return repositorio.save(existente);

    }



    public void eliminarViaje(Long id){
        buscarViajeId(id);
        repositorio.deleteById(id);
    }



}