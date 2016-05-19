package com.example.prueba.pc1_programoviles.presenter;

import android.util.Log;

import com.example.prueba.pc1_programoviles.beans.Alumno;
import com.example.prueba.pc1_programoviles.beans.MsgResponse;
import com.example.prueba.pc1_programoviles.remote.Connection;
import com.example.prueba.pc1_programoviles.remote.Service;
import com.example.prueba.pc1_programoviles.view.LoginView;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

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

        conexion.login(alumno).enqueue(new Callback<MsgResponse>() {
            @Override
            public void onResponse(Response<MsgResponse> response) {
                Log.e("mensaje", response.body().getMsg());

                loginView.loginCorrecto();
                if (response.body().getMsg() != "OK"){
                    loginView.mostrarLoginIncorrecto();
                }else{
                    loginView.loginCorrecto();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("problema =(", t.getMessage());
            }
        });
    }
}
