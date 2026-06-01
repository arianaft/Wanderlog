package com.wanderlog.exception;

public class ErrorResponse {
    private int status;
    private String mensaje;


//Constructor


    public ErrorResponse(int status, String mensaje) {
        this.status = status;
        this.mensaje = mensaje;
    }

    //SETTERS

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


    //GETTERS

    public int getStatus() {
        return status;
    }

    public String getMensaje() {
        return mensaje;
    }
}