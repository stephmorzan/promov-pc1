package com.example.prueba.pc1_programoviles.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prueba.pc1_programoviles.R;
import com.example.prueba.pc1_programoviles.beans.Alumno;
import com.example.prueba.pc1_programoviles.presenter.LoginPresenter;
import com.example.prueba.pc1_programoviles.presenter.LoginPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.eteUsuario)
    EditText eteUsuario;

    @BindView(R.id.etePassword)
    EditText etePassword;

    @BindView(R.id.butLogin)
    Button butLogin;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        loginPresenter = new LoginPresenterImpl(this);
        /*butLogin = (Button) findViewById(R.id.butLogin);
        eteUsuario = (EditText)findViewById(R.id.eteUsuario);
        etePassword = (EditText)findViewById(R.id.etePassword);*/
        Log.e("butLogin", butLogin.toString());
        butLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = (eteUsuario.getText().toString());
                Log.e("numUsuario", usuario+"");
                String password = etePassword.getText().toString();
                Log.e("password", password);
                Alumno alumno = new Alumno(usuario, password);
                loginPresenter.loguearAlumno(alumno);
            }
        });
    }


    @Override
    public void loginCorrecto() {
        Log.e("!!!!!!!!!!!!!!!!!!", "holi");
        Intent intent = new Intent();
        intent.setClass(LoginActivity.this, ListarEquiposActivity.class);
        //intent.putExtra("usuario", Integer.parseInt(eteUsuario.getText().toString()));
        startActivity(intent);
    }

    @Override
    public void mostrarLoginIncorrecto() {
        Toast.makeText(this, "Login incorrecto. Revise los datos", Toast.LENGTH_SHORT).show();
    }
}
