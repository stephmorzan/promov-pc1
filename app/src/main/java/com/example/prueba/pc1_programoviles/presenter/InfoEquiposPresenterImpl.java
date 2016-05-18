package com.example.prueba.pc1_programoviles.presenter;

import android.util.Log;

import com.example.prueba.pc1_programoviles.beans.Equipo;
import com.example.prueba.pc1_programoviles.remote.Connection;
import com.example.prueba.pc1_programoviles.remote.Service;
import com.example.prueba.pc1_programoviles.view.InfoEquiposView;

import retrofit.Callback;
import retrofit.Response;

/**
 * Created by stmorzan on 17/05/2016.
 */
public class InfoEquiposPresenterImpl implements InfoEquiposPresenter{

    Service conexion;
    private InfoEquiposView infoEquiposView;

    public InfoEquiposPresenterImpl(InfoEquiposView view) {
        infoEquiposView = view;
    }

    @Override
    public void obtenerInfoEquipo(int id) {
        conexion=Connection.conectar();

        conexion.obtenerEquipo(id).enqueue(new Callback<Equipo>() {
            @Override
            public void onResponse(Response<Equipo> response) {
                if (response.body()!=null){
                    infoEquiposView.mostrarInfoEquipo(response.body());
                }else{

                }

            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("problema InfoEquipos =(", t.getMessage());
            }
        });
    }
}
