package com.wanderlog;

import com.wanderlog.model.Actividad;
import com.wanderlog.model.Destino;
import com.wanderlog.model.Usuario;
import com.wanderlog.model.Viaje;
import com.wanderlog.model.enums.Rol;
import com.wanderlog.model.enums.TipoActividad;

import java.time.LocalDate;

import static com.wanderlog.model.enums.VisibilidadViaje.PUBLICO;

public class Main {
    public static void main (String [] args){
        Usuario usuario = new Usuario(1L, "Laura","Laurag@gmail.com", Rol.VIAJERO);
        Viaje viaje = new Viaje(1L, "Madrid Ideal", "Este es el viaje de tus sueños", LocalDate.of(2026,6,06), LocalDate.of(2026,6,07), PUBLICO, usuario);
        Destino destino = new Destino(2L, "Madrid", "España", "Clima mediterráneo");
        Actividad actividad = new Actividad(1L, "Pracaidismo", "Caer desde un avión", TipoActividad.AVENTURA , LocalDate.of(2026,7,5));

        //Llamada a metodos

        destino.agregarActividad(actividad);
        viaje.agregarDestino(destino);

        System.out.println("Nombre viajero: " + usuario.getNombre() +
                            " Titulo: " + viaje.getTitulo() +
                            " Destinos del viaje:  " + viaje.getDestinos().size());
    }
}
