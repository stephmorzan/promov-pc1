package com.example.prueba.pc1_programoviles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prueba.pc1_programoviles.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

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
        butLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String usuario = eteUsuario.getText().toString();
        String password = etePassword.getText().toString();

        if(false){
            Toast.makeText(this,"Login incorrecto. Verifique datos.", Toast.LENGTH_SHORT).show();
        }
    }
}
