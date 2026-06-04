package com.wanderlog.model;

import com.wanderlog.model.enums.TipoActividad;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

//Clase

@Entity
public class Actividad {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String descripcion;
    private TipoActividad tipo;
    private LocalDate fecha;

    @ManyToOne
    private Destino destino;

    public Actividad (){}

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
