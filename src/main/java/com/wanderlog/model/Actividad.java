package com.wanderlog.model;

import com.wanderlog.model.enums.TipoActividad;

import java.time.LocalDate;

//Clase

public class Actividad {
    private Long id;
    private String nombre;
    private String descripcion;
    private TipoActividad tipo;
    private LocalDate fecha;

    //Constructor
    public Actividad(Long id , String nombre, String descripcion, TipoActividad tipo, LocalDate fecha){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public TipoActividad getTipo() {
        return tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }


}
