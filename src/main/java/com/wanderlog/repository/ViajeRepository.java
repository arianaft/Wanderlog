package com.wanderlog.repository;

import com.wanderlog.exception.ViajeNotFoundException;
import com.wanderlog.model.Viaje;

import java.util.ArrayList;
import java.util.List;

public class ViajeRepository {

    //Lista
    private List<Viaje> viajes = new ArrayList<>();

    //Metodo guarda viaje

    public void guardar (Viaje viaje){
        viajes.add(viaje);
    }

    //Lista devuelve viajes

    public List<Viaje> obtenerTodos(){
        return viajes;
    }

    //Metodo busca por id

    public Viaje buscarPorId(Long id){
        return viajes.stream()
                .filter(v ->v.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ViajeNotFoundException(id));
    }


}
