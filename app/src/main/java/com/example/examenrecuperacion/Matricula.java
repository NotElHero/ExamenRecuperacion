package com.example.examenrecuperacion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class Matricula extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText nombre, apellidos, email;
    Button matricular, volver;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matricula);

        nombre = (EditText) findViewById(R.id.textoNombre);
        apellidos = (EditText) findViewById(R.id.textoApellidos);
        email = (EditText) findViewById(R.id.textoEmail);

        matricular = (Button) findViewById(R.id.botonMatricular);
        matricular.setOnClickListener(this);
        volver = (Button) findViewById(R.id.botonVolver);
        volver.setOnClickListener(this);

        String cursos[] = {"DAM", "DAW", "ASIR"};

        Spinner curso = findViewById(R.id.spinner);
        curso.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(Matricula.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, cursos);
        curso.setAdapter(adapter);

        db = openOrCreateDatabase("lista", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS lista(Nombre TEXT PRIMARY KEY, Apellidos TEXT, Email TEXT, Curso INTEGER);");
    }

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.botonMatricular:
                Intent matricular = new Intent(this, Clase.class);
                startActivity(matricular);
                break;
            case R.id.botonVolver:
                Intent volver = new Intent(this, MainActivity.class);
                startActivity(volver);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.itemAcercade) {
            Toast creador = Toast.makeText(this, "Javier Villacorta Garcia", Toast.LENGTH_SHORT);
            creador.show();
            return true;
        } else if (id == R.id.itemMapa){
            Intent mapa = new Intent(this, Mapa.class);
            startActivity(mapa);
        }
        return super.onOptionsItemSelected(item);
    }
    /*public void matriculado(){
        db.execSQL("INSERT INTO lista VALUES (NULL,'"+tiempoFin+"')");
        System.out.println("Alumno añadido");
        db.close();
    } */
}
