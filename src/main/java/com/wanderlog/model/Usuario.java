package com.wanderlog.model;

import com.wanderlog.model.enums.Rol;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;


@Entity
    //Clase
public class Usuario {
    @Id
    @GeneratedValue
    private long id;

    private String nombre;
    private String email;

    @Enumerated(EnumType.STRING)
    private Rol rol;
    private String password;

    public Usuario(){}

    //Constructor de la clase Usuario
    public Usuario(long id, String nombre, String email, Rol rol){
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }

        public long getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getPassword() {
        return password;
        }

        public String getEmail() {
            return email;
        }
        public Rol getRol() {
            return rol;
        }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setPassword(String password) {
        this.password = password;
        }

    }

