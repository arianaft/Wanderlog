package com.wanderlog.service;

import com.wanderlog.model.Viaje;
import com.wanderlog.repository.ViajeRepository;

import java.util.ArrayList;
import java.util.List;

public class ViajeService {

    private ViajeRepository repositorio = new ViajeRepository();

    //Metodo guardar
    public void guardarViaje(Viaje viaje) {
        repositorio.guardar(viaje);
    }

    //Metodo devuelve todos los viajes

    public List<Viaje> obtenerTodosViajes(){
        return repositorio.obtenerTodos();
    }

    //Metodo buscar por id
    public Viaje buscarViajeId(Long id){
        return repositorio.buscarPorId(id);
    }
}