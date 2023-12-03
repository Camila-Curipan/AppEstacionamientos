package com.example.led;
/*aca copie y pegue los metodos de bd de un crud para que queden guardados
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MetodosDb extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        public void onClickAgregar(View view){
            DataHelper dh = new DataHelper(this, "producto.db", null, 1);
            SQLiteDatabase bd = dh.getWritableDatabase();
            ContentValues reg = new ContentValues();
            reg.put("nom", edtNom.getText().toString());
            reg.put("des", edtDes.getText().toString());
            reg.put("cost", edtCost.getText().toString());
            reg.put("cat", spSpinner.getSelectedItem().toString());
            long resp = bd.insert("producto", null, reg);
            bd.close();
            if (resp == -1){
                Toast.makeText(this,"No se pudo Ingresar",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Dato Ingresado Correctamente",Toast.LENGTH_LONG).show();
            }
            CargarLista();
            Limpiar();
        }


        public void onClickModificar(View view){
            DataHelper dh = new DataHelper(this, "producto.db", null, 1);
            SQLiteDatabase bd = dh.getWritableDatabase();
            ContentValues reg = new ContentValues();
            reg.put("nom", edtNom.getText().toString());
            reg.put("des", edtDes.getText().toString());
            reg.put("cost", edtCost.getText().toString());
            reg.put("cat", spSpinner.getSelectedItem().toString());
            long resp  = bd.update("producto", reg, "idProd=?", new String[]
                    {edtIdProd.getText().toString()});
            bd.close();
            if(resp == -1){
                Toast.makeText(this, "No se pudo Modificar",
                        Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, "Dato Modificado",
                        Toast.LENGTH_LONG).show();
            }
            CargarLista();
            Limpiar();
        }



        public void onClickEliminar(View view){
            DataHelper dh = new DataHelper(this, "producto.db",  null, 1);
            SQLiteDatabase bd = dh.getWritableDatabase();
            String bIdProd = edtIdProd.getText().toString();
            long resp = bd.delete("producto", "idProd="+ bIdProd, null);
            bd.close();
            if(resp ==-1){
                Toast.makeText(this, "No se pudo Eliminar",
                        Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Dato Eliminado",
                        Toast.LENGTH_LONG).show();
            }
            Limpiar();
            CargarLista();
        }

        public void Limpiar(){
            edtIdProd.setText("");
            edtDes.setText("");
            edtNom.setText("");
            edtCost.setText("");
        }
    }
}

 */
