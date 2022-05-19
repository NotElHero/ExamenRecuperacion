package com.example.examenrecuperacion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Clase extends Activity implements View.OnClickListener {

    Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clase);

        volver = (Button) findViewById(R.id.botonBack);
        volver.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent volver = new Intent(this, Matricula.class);
        startActivity(volver);
    }
}
