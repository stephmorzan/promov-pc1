package com.example.prueba.pc1_programoviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prueba.pc1_programoviles.beans.Alumno;
import com.example.prueba.pc1_programoviles.presenter.LoginPresenter;
import com.example.prueba.pc1_programoviles.presenter.LoginPresenterImpl;
import com.example.prueba.pc1_programoviles.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    EditText eteUsuario;
    EditText etePassword;
    Button butLogin;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter = new LoginPresenterImpl(this);
        butLogin = (Button) findViewById(R.id.butLogin);
        eteUsuario = (EditText)findViewById(R.id.eteUsuario);
        etePassword = (EditText)findViewById(R.id.etePassword);
        ButterKnife.bind(this);
        butLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int usuario = Integer.parseInt(eteUsuario.getText().toString());
        Log.e("numUsuario", usuario+"");
        String password = etePassword.getText().toString();
        Log.e("password", password);
        Alumno alumno = new Alumno(usuario, password);
        loginPresenter.loguearAlumno(alumno);
    }

    @Override
    public void loginCorrecto() {
        Intent intent = new Intent();
        intent.setClass(LoginActivity.this, MainActivity.class);
        intent.putExtra("usuario", Integer.parseInt(eteUsuario.getText().toString()));
        startActivity(intent);
    }

    @Override
    public void mostrarLoginIncorrecto() {
        Toast.makeText(this, "Login incorrecto. Revise los datos", Toast.LENGTH_SHORT).show();
    }
}
