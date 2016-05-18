package com.example.prueba.pc1_programoviles.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prueba.pc1_programoviles.R;
import com.example.prueba.pc1_programoviles.beans.Equipo;
import com.example.prueba.pc1_programoviles.presenter.ListarEquiposPresenter;
import com.example.prueba.pc1_programoviles.presenter.ListarEquiposPresenterImpl;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListarEquiposActivity extends AppCompatActivity implements ListarEquiposView {

    @BindView(R.id.gridView)
    GridView gridView;

    ListarEquiposPresenter listarEquiposPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_equipos);
        ButterKnife.bind(this);

        listarEquiposPresenter = new ListarEquiposPresenterImpl(this);
        listarEquiposPresenter.getEquipos();
    }

    @Override
    public void mostrarEquipos(final List<Equipo> equipoList) {
        gridView.setAdapter(new EquipoAdapter(this, (ArrayList)equipoList));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setClass(ListarEquiposActivity.this, LoginActivity.class);
                intent.putExtra("id",equipoList.get(i).getId());
                Log.e("qué vale i =S", equipoList.get(i).getId()+"");
                //intent.putExtra("usuario", Integer.parseInt(eteUsuario.getText().toString()));
                startActivity(intent);
            }
        });
    }
}


class EquipoAdapter extends BaseAdapter{

    ArrayList<Equipo> list;
    Context context;

    EquipoAdapter(Context context, ArrayList<Equipo> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    class ViewHolder {
        TextView textView;
        ImageView imageView;

        ViewHolder(View v){
            textView = (TextView) v.findViewById(R.id.nomEquipo);
            imageView = (ImageView) v.findViewById(R.id.imgEquipo);
        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = null;

        if (row == null) {
            LayoutInflater inflater
                    = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row = inflater.inflate(R.layout.equipo_item, viewGroup, false);
            holder = new ViewHolder(row);
            row.setTag(holder);
        }else{
            holder = (ViewHolder) row.getTag();
        }
        Equipo eq = list.get(i);
        Log.e("" + i, eq.getNombre() + "");
        holder.textView.setText(eq.getNombre());
        Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(holder.imageView);

        return row;
    }
}