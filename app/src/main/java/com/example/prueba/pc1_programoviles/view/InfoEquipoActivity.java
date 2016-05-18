package com.example.prueba.pc1_programoviles.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prueba.pc1_programoviles.R;
import com.example.prueba.pc1_programoviles.beans.Equipo;
import com.example.prueba.pc1_programoviles.presenter.InfoEquiposPresenter;
import com.example.prueba.pc1_programoviles.presenter.InfoEquiposPresenterImpl;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoEquipoActivity extends AppCompatActivity implements InfoEquiposView{

    @BindView(R.id.tviNombEquipo)
    TextView tviNombEquipo;
    @BindView(R.id.iviEquipo)
    ImageView iviEquipo;
    TextView partidosGanados;
    TextView partidosPerdidos;

    InfoEquiposPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_equipo);

        /*tviNombEquipo=(TextView)findViewById(R.id.tviNombEquipo);
        iviEquipo=(ImageView)findViewById(R.id.iviEquipo);
        partidosGanados = (TextView) findViewById(R.id.tviPartidosGanados);
        partidosPerdidos = (TextView) findViewById(R.id.tviPartidosPerdidos); */

        ButterKnife.bind(this);

        presenter = new InfoEquiposPresenterImpl(this);

        Intent intent = getIntent();
        int id = Integer.parseInt(intent.getStringExtra("id"));

        presenter.obtenerInfoEquipo(id);
    }

    @Override
    public void mostrarInfoEquipo(Equipo equipo) {
        tviNombEquipo.setText(equipo.getNombre());
        Picasso.with(this).load(equipo.getUrlFoto()).into(iviEquipo);
        partidosGanados.setText("Partidos ganados: " + equipo.getPartidosGanados());
        partidosPerdidos.setText("Partidos perdidos: " + equipo.getPartidosPerdidos());
    }
}
