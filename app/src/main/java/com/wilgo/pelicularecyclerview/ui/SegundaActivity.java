package com.wilgo.pelicularecyclerview.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.wilgo.pelicularecyclerview.R;
import com.wilgo.pelicularecyclerview.modelos.Pelicula;

public class SegundaActivity extends AppCompatActivity {

    private SegundaViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda);

        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(SegundaViewModel.class);
        vm.getMutablePelicula().observe(this, new Observer<Pelicula>() {
            @Override
            public void onChanged(Pelicula pelicula) {
                TextView titulo = findViewById(R.id.titulo2);
                titulo.setText(pelicula.getTitulo());

                TextView reseña = findViewById(R.id.reseña2);
                reseña.setText(pelicula.getReseña());

                ImageView imagen = findViewById(R.id.imagen2);
                imagen.setImageResource(pelicula.getImagen());

                //ademas los actores y el director
                TextView actores = findViewById(R.id.actores);
                actores.setText(pelicula.getActores());

                TextView director = findViewById(R.id.director);
                director.setText(pelicula.getDirector());
            }
        });

        vm.recuperarPelicula(getIntent());

        Button botonVolver = findViewById(R.id.botonVolver);
        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}