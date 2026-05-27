package com.wanderlog;

import com.wanderlog.exception.ViajeNotFoundException;
import com.wanderlog.model.Actividad;
import com.wanderlog.model.Destino;
import com.wanderlog.model.Usuario;
import com.wanderlog.model.Viaje;
import com.wanderlog.model.enums.Rol;
import com.wanderlog.model.enums.TipoActividad;
import com.wanderlog.model.enums.VisibilidadViaje;
import com.wanderlog.repository.ViajeRepository;
import com.wanderlog.service.ViajeService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.wanderlog.model.enums.VisibilidadViaje.PRIVADO;
import static com.wanderlog.model.enums.VisibilidadViaje.PUBLICO;



public class Main {
    public static void main (String [] args){
        //OBJETOS

        Usuario usuario = new Usuario(1L, "Laura","Laurag@gmail.com", Rol.VIAJERO);
        Viaje viaje = new Viaje(1L, "Madrid Ideal", "Este es el viaje de tus sueños", LocalDate.of(2026,6,06), LocalDate.of(2026,6,07), PUBLICO, usuario);
        Destino destino = new Destino(2L, "Madrid", "España", "Clima mediterráneo");
        Actividad actividad = new Actividad(1L, "Pracaidismo", "Caer desde un avión", TipoActividad.AVENTURA , LocalDate.of(2026,7,5));

        Viaje viaje2 = new  Viaje(2L, "Valencia", "Aqui tiene playas magnificas", LocalDate.of(2026, 6, 25), LocalDate.of(2026,7,20), PUBLICO, usuario);
        Viaje viaje3 = new  Viaje(3L, "Milán", "Todo a la moda", LocalDate.of(2026, 5, 25), LocalDate.of(2026,6,20), PRIVADO, usuario);



       //Objeto Service
        ViajeService servicio = new ViajeService();
        servicio.guardarViaje(viaje);
        servicio.guardarViaje(viaje2);
        servicio.guardarViaje(viaje3);


        //For each

        servicio.obtenerTodosViajes().forEach(v->System.out.println(v.getTitulo()));

        //Stream

        List<Viaje> viajesPublicos =  servicio.obtenerTodosViajes().stream()
                .filter(v -> v.getTitulo().contains("a"))
                .collect(Collectors.toList());
        System.out.println("Viajes que contengan a: " + viajesPublicos.size());

        //Buscar viaje por id

        Viaje encontrado = servicio.buscarViajeId(2L);
        System.out.println("Encontrado " + encontrado.getTitulo());



        //Llamada a metodos

        destino.agregarActividad(actividad);
        viaje.agregarDestino(destino);

        System.out.println("\nNombre viajero: " + usuario.getNombre() +
                            " Titulo: " + viaje.getTitulo() +
                            " Destinos del viaje:  " + viaje.getDestinos().size());
    }
}
