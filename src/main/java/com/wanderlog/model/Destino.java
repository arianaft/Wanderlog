package com.wanderlog.model;
import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;

//Clase


@Entity
public class Destino {
    @Id
    @GeneratedValue
    private Long id;

    private String ciudad;
    private String pais;
    private String descripcion;
    @OneToMany(mappedBy = "destino", cascade = CascadeType.ALL)
    private List<Actividad> actividades = new ArrayList<>();

    @ManyToOne
    private Viaje viaje;


    public Destino(){}

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

    //Metodo

    public void agregarActividad(Actividad actividades){
        this.actividades.add(actividades);
    }
}
