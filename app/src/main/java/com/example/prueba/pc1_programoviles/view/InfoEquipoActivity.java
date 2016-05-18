package com.example.prueba.pc1_programoviles.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prueba.pc1_programoviles.R;
import com.example.prueba.pc1_programoviles.presenter.InfoEquiposPresenter;
import com.example.prueba.pc1_programoviles.presenter.InfoEquiposPresenterImpl;

public class InfoEquipoActivity extends AppCompatActivity implements InfoEquiposView{

    TextView tviNombEquipo;
    ImageView iviEquipo;
    TextView partidosGanados;
    TextView partidosPerdidos;

    InfoEquiposPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_equipo);
        presenter = new InfoEquiposPresenterImpl(this);

        Intent intent = getIntent();
        int id = Integer.parseInt(intent.getStringExtra("id"));

        presenter.obtenerInfoEquipo(id);
    }

    @Override
    public void mostrarInfoEquipo() {

    }
}
