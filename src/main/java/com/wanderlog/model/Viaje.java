package com.wanderlog.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.wanderlog.model.enums.VisibilidadViaje;

//Clase
public class Viaje {
    private long id;
    private String titulo;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private VisibilidadViaje visibilidad;
    private Usuario usuario;
    private  List<Destino> destinos;


    //Constructor
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

    //Metodo
    public void agregarDestino(Destino destinos){
         this.destinos.add(destinos);
    }


}




