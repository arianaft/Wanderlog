package com.wanderlog.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.wanderlog.model.enums.VisibilidadViaje;
import jakarta.persistence.*;


@Entity



//Clase
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @Enumerated(EnumType.STRING)
    private VisibilidadViaje visibilidad;

    @Transient
    private Usuario usuario;

    @Transient
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




