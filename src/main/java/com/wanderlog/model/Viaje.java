package com.wanderlog.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wanderlog.model.enums.VisibilidadViaje;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity



//Clase
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String titulo;
    private String descripcion;

    @NotNull
    private LocalDate fechaInicio;
    @NotNull
    private LocalDate fechaFin;

    @Enumerated(EnumType.STRING)
    @NotNull
    private VisibilidadViaje visibilidad;

    @Transient
    private Usuario usuario;

    @OneToMany(mappedBy = "viaje", cascade =  CascadeType.ALL)
    private  List<Destino> destinos;


    //Constructor
    public Viaje (){}

    public Viaje(long id, String titulo, String descripcion, LocalDate fechaInicio,LocalDate fechaFin,
                 VisibilidadViaje visibilidad, Usuario usuario){
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.visibilidad = visibilidad;
        this.usuario = usuario;
        this.destinos = new ArrayList<>();

    }

    //Getters

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public VisibilidadViaje getVisibilidad() {
        return visibilidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Destino> getDestinos() {
        return destinos;
    }


    //Setters

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setVisibilidad(VisibilidadViaje visibilidad) {
        this.visibilidad = visibilidad;
    }



    //Metodo
    public void agregarDestino(Destino destinos){
         this.destinos.add(destinos);
    }


}




