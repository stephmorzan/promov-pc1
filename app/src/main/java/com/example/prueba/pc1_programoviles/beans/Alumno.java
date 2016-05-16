package com.example.prueba.pc1_programoviles.beans;

/**
 * Created by W3222 on 11/05/2016.
 */
public class Alumno {

    private String nombre;
    private int usuario;
    private String password;

    public Alumno() {
    }

    public Alumno(int usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public Alumno(String nombre, int usuario) {
        this.nombre = nombre;
        this.usuario = usuario;
    }

    public Alumno(String nombre, int usuario, String password) {
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

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
