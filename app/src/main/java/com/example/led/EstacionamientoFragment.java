package com.example.led;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EstacionamientoFragment extends Fragment {
    /* Yo supongo que es aca donde se muestran solo los estacionamientos disponibles y
    se selecciona el que deseamos que nos arroje lecturas de distancia
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Infla el diseño de tu fragmento
        View rootView = inflater.inflate(R.layout.activity_estacionamientos, container, false);
        return rootView;
    }


}
