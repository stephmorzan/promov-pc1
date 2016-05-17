package com.example.prueba.pc1_programoviles.beans;

/**
 * Created by W3222 on 11/05/2016.
 */
public class Alumno {

    private String nombre;
    private String usuario;
    private String password;

    public Alumno() {
    }


    public Alumno(String nombre, String usuario) {
        this.nombre = nombre;
        this.usuario = usuario;
    }

    public Alumno(String nombre, String usuario, String password) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
