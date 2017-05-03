package com.federico.velector;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTextos extends AppCompatActivity {

    lista_entrada[] datos = new lista_entrada[]{
            new lista_entrada(10000,"El cuervo","Edgar Allan Poe"),
            new lista_entrada(15000,"El gato negro","Edgar Allan Poe"),
            new lista_entrada(20000,"For whom the bell tolls","Ernest Hemiway"),
            new lista_entrada(25000,"Da vinci Code","Dan Brown"),

    };

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textos);

        Adapter adapter = new Adapter(this,datos);
        lista = (ListView)findViewById(R.id.lista);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String opcion = ((lista_entrada)parent.getItemAtPosition(position)).getTitulo();

                Toast.makeText(getApplicationContext(),opcion,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ActivityTextos.this, ActivityAjustes.class);
                startActivity(intent);

            }
        });


    }

    class Adapter extends ArrayAdapter<lista_entrada> {

        public Adapter(Context context, lista_entrada[] datos) {
            super(context, R.layout.listview_item,datos);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listview_item,null);

            TextView nombre = (TextView) item.findViewById(R.id.ttitulo);
            nombre.setText(datos[position].getTitulo());

            TextView descrip = (TextView) item.findViewById(R.id.tautor);
            descrip.setText(datos[position].getAutor());

            TextView precio = (TextView) item.findViewById(R.id.words);
            precio.setText(String.valueOf(datos[position].getWords()));
            //return super.getView(position, convertView, parent);

            return item;
        }
    }

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(ActivityTextos.this,MainActivity.class);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}
