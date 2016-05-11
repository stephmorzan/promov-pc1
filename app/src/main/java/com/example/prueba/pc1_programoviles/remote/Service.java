package com.example.prueba.pc1_programoviles.remote;

import com.example.prueba.pc1_programoviles.beans.Alumno;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by W3222 on 11/05/2016.
 */
public interface Service {

    @POST("alumnos/login")
    retrofit2.Call login(@Body Alumno alumno);

    @GET("alumnos/?sin_equipo=")
    retrofit2.Call<List<Alumno>> obtenerAlumnos();
}
