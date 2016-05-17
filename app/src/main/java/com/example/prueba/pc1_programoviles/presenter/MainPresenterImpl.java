package com.example.prueba.pc1_programoviles.presenter;

import android.util.Log;

import com.example.prueba.pc1_programoviles.beans.Equipo;
import com.example.prueba.pc1_programoviles.remote.Connection;
import com.example.prueba.pc1_programoviles.remote.Service;
import com.example.prueba.pc1_programoviles.view.LoginView;
import com.example.prueba.pc1_programoviles.view.MainView;

import java.io.IOException;
import java.util.List;

import retrofit.Callback;
import retrofit.Response;

/**
 * Created by Enzo on 16/05/16.
 */
public class MainPresenterImpl implements MainPresenter{

    private MainView mainView;
    Service conexion;

    public MainPresenterImpl(MainView view) {
        mainView = view;
    }

    @Override
    public void getEquipos() {
        conexion= Connection.conectar();
        Log.e("!!!!!!!!!!!!!!!!", "getEquipos");
        conexion.obtenerEquipos().enqueue(new Callback<List<Equipo>>() {
            @Override
            public void onResponse(Response<List<Equipo>> response) {
                /*Log.e("!!!!!!!!!!!!!!!!", "onResponse");
                Log.e("mensaje", ""+response.message());
                Log.e("mensaje", ""+response.body());

                Log.e("mensaje", ""+response.errorBody());*/

                mainView.mostrarEquipos(response.body());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
