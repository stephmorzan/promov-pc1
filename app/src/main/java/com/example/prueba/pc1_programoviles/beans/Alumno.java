package com.example.prueba.pc1_programoviles.beans;

/**
 * Created by W3222 on 11/05/2016.
 */
public class Alumno {

    private String nombre;
    private int codigoUser;
    private String password;

    public Alumno() {
    }

    public Alumno(int codigoUser, String password) {
        this.codigoUser = codigoUser;
        this.password = password;
    }

    public Alumno(String nombre, int codigoUser) {
        this.nombre = nombre;
        this.codigoUser = codigoUser;
    }

    public Alumno(String nombre, int codigoUser, String password) {
        this.nombre = nombre;
        this.codigoUser = codigoUser;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoUser() {
        return codigoUser;
    }

    public void setCodigoUser(int codigoUser) {
        this.codigoUser = codigoUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
