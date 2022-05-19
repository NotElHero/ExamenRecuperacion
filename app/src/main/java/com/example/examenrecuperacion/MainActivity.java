package com.example.examenrecuperacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button botonMatricularse;
    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonMatricularse = (Button) findViewById(R.id.botonMatricularse);
        botonMatricularse.setOnClickListener(this);

        video = (VideoView) findViewById(R.id.videoView);
        video.setVideoURI(Uri.parse("https://www.elnortedecastilla.es/valladolid/aniversario-julian-marias-20220325230806-video.html"));
        video.requestFocus();
        video.start();
    }

    @Override
    public void onClick(View view) {
        Intent matricularse= new Intent(this, Matricula.class);
        startActivity(matricularse);
    }
}