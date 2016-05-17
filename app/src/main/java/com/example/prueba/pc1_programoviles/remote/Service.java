package com.example.prueba.pc1_programoviles.remote;

import com.example.prueba.pc1_programoviles.beans.Alumno;
import com.example.prueba.pc1_programoviles.beans.Equipo;
import com.example.prueba.pc1_programoviles.beans.MsgResponse;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by W3222 on 11/05/2016.
 */
public interface Service {

    @POST("alumnos/login")
    Call<MsgResponse> login(@Body Alumno alumno);

    @GET("alumnos/?sin_equipo=")
    Call<List<Alumno>> obtenerAlumnos();

    @GET("equipos")
    Call<List<Equipo>> obtenerEquipos();

    @GET("equipos/")
    Call<Equipo> obtenerEquipo();
}
