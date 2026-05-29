package com.wanderlog.service;

import com.wanderlog.exception.ViajeNotFoundException;
import com.wanderlog.model.Viaje;
import com.wanderlog.repository.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ViajeService {

    @Autowired
    private ViajeRepository repositorio;

    //Guarda viajes

    public void guardarViaje(Viaje viaje) {
        repositorio.save(viaje);
    }

    //Devuelve todos los viajes

    public List<Viaje> obtenerTodosViajes(){
        return repositorio.findAll();
    }

    //Buscar por id

    public Viaje buscarViajeId(Long id){
        return repositorio.findById(id).orElseThrow(() -> new ViajeNotFoundException(id));
    }
}