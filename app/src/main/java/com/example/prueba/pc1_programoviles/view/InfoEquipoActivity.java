package com.example.prueba.pc1_programoviles.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prueba.pc1_programoviles.R;

public class InfoEquipoActivity extends AppCompatActivity {

    TextView tviNombEquipo;
    ImageView iviEquipo;
    TextView partidosGanados;
    TextView partidosPerdidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_equipo);
    }
}
