package com.wilgo.pelicularecyclerview.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wilgo.pelicularecyclerview.R;
import com.wilgo.pelicularecyclerview.modelos.Pelicula;

import java.util.List;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.ViewHolder> {
    private List<Pelicula> listaPelicula;
    private Context context;

    private LayoutInflater li;

    public PeliculaAdapter(List<Pelicula> listaPelicula, Context context, LayoutInflater li) {
        this.listaPelicula = listaPelicula;
        this.context = context;
        this.li = li;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pelicula pelicula = listaPelicula.get(position);

        holder.titulo.setText(pelicula.getTitulo());
        holder.reseña.setText(pelicula.getReseña());
        holder.imagen.setImageResource(pelicula.getImagen());

        //el boton
        holder.btnDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SegundaActivity.class);
                intent.putExtra("pelicula", pelicula);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent); // Iniciar la actividad aquí
            }
        });
    }


    @Override
    public int getItemCount() {
        return listaPelicula.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titulo, reseña;
        ImageView imagen;
        Button btnDetalle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.titulo2);
            reseña = itemView.findViewById(R.id.reseña2);
            imagen = itemView.findViewById(R.id.imagen2);
            btnDetalle = itemView.findViewById(R.id.btnDetalles);
        }
    }
}

