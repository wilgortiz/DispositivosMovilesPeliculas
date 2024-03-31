package com.wilgo.pelicularecyclerview.ui;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.wilgo.pelicularecyclerview.R;
import com.wilgo.pelicularecyclerview.modelos.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ActivityMainViewModel extends AndroidViewModel {
    private MutableLiveData<List<Pelicula>> listaMutable;

    public ActivityMainViewModel(@NonNull Application application, MutableLiveData<List<Pelicula>> listaMutable) {
        super(application);
        this.listaMutable = listaMutable;
    }

    public ActivityMainViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<List<Pelicula>> getListaMutable(){
        if(listaMutable==null){
            listaMutable = new MutableLiveData<>();
        }
        return listaMutable;
    }

    public void crearLista(){
        ArrayList<Pelicula> lista =new ArrayList<>();
        lista.add(new Pelicula("Terminator 2","Dos androides del futuro intentan apoderarse " +
                "de un adolescente (Edward Furlong) que se convertirá en el salvador " +
                "de la Tierra.", R.drawable.terminator,"Arnold Scwarzeneger","Steven Spielberg"));
        lista.add(new Pelicula("Titanic","Una joven de la alta sociedad abandona a su arrogante " +
                "pretendiente por un artista humilde en el trasatlántico que se hundió durante su " +
                "viaje inaugural.", R.drawable.titanic,"Leonardo Di Caprio","Steven Spielberg"));
        lista.add(new Pelicula("Harry Potter","El día de su cumpleaños, Harry Potter descubre que es" +
                " hijo de dos conocidos hechiceros, de los que ha heredado poderes mágicos.",
                R.drawable.harry,"Daniel Radcliffe","Chris Columbus"));

        listaMutable.setValue(lista);
    }
    public void verDetalle(){
        Intent intent = new Intent(getApplication().getApplicationContext(),SegundaActivity.class);
//        intent.putExtra("detalle",actores);
    }


}
