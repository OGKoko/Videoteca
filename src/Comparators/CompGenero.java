package Comparators;

import Model.Pelicula;

import java.util.Comparator;

public class CompGenero implements Comparator<Pelicula> {

    @Override
    public int compare(Pelicula p1, Pelicula p2) {  //en este caso esta ordenando por genero en caso de que el genero sea el mismo
        if (p1.getGenero().equals(p2.getGenero())){ // lo devolverá por num de votos
            return p2.getVotos()-p1.getVotos();
        }else{
            return p1.getGenero().compareTo(p2.getGenero());
        }
    }
}
