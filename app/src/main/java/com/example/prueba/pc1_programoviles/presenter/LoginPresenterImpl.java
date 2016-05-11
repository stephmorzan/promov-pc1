package com.example.prueba.pc1_programoviles.presenter;

import android.util.Log;

import com.example.prueba.pc1_programoviles.beans.Alumno;
import com.example.prueba.pc1_programoviles.remote.Connection;
import com.example.prueba.pc1_programoviles.remote.Service;
import com.example.prueba.pc1_programoviles.view.LoginView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by W3222 on 11/05/2016.
 */
public class LoginPresenterImpl implements LoginPresenter{

    private LoginView loginView;
    Service conexion;

    public LoginPresenterImpl(LoginView view) {
        loginView = view;
    }

    @Override
    public void loguearAlumno(Alumno alumno) {
        conexion= Connection.conectar();

        conexion.login(alumno).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("servRemoto =D", t.getMessage());
            }
        });
    }
}
