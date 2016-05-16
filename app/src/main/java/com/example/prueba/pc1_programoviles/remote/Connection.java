package com.example.prueba.pc1_programoviles.remote;

import retrofit.Retrofit;
import retrofit.GsonConverterFactory;

/**
 * Created by W3222 on 11/05/2016.
 */
public class Connection {

    public static Service conectar(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pichangers-api.mybluemix.net/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);

    }

}
