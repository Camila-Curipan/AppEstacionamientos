package com.example.led;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class RegistrosFRagment extends Fragment {


    ListView lista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Infla el diseño de tu fragmento
        View rootView = inflater.inflate(R.layout.activity_registros, container, false);
        return rootView;
        //ka esta pasandaaaah!!!
        lista = findViewById(R.id.lstLista);

        CargarLista();

    }

    private void CargarLista() {

        DataHelper dh = new DataHelper(this, "RegistrosEstacionamientos.db", null, 1);
        SQLiteDatabase bd = dh.getWritableDatabase();
        Cursor c = bd.rawQuery("SELECT fecha ,numEst ,horaEnt ,horaSal FROM producto", null);
        String[] arr = new String[c.getCount()];
        if(c.moveToFirst() == true){
            int i = 0;
            do{
                String linea = "" + c.getString(0)+
                        " || " + c.getString(1) + "||" + c.getString(3)+
                        " || $"+ c.getString(4) ;
                arr[i] = linea;
                i++;
            }while (c.moveToNext() == true);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>
                    (this, android.R.layout.simple_expandable_list_item_1, arr);
            lista.setAdapter(adapter);
            bd.close();
        }

    }


}