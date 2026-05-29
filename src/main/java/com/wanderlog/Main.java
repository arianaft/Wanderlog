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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.wanderlog.model.enums.VisibilidadViaje.PRIVADO;
import static com.wanderlog.model.enums.VisibilidadViaje.PUBLICO;


@SpringBootApplication

public class Main {
    public static void main (String [] args){
        SpringApplication.run(Main.class, args);

    }
}
