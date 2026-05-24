package com.wanderlog.model;
import java.util.List;
import java.util.ArrayList;

//Clase



public class Destino {
    private Long id;
    private String ciudad;
    private String pais;
    private String descripcion;
    private List<Actividad> actividades;


    //Constructor
    public Destino(Long id, String ciudad, String pais, String descripcion){
        this.id = id;
        this.ciudad = ciudad;
        this.pais = pais;
        this.descripcion = descripcion;
        this.actividades= new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }
}
