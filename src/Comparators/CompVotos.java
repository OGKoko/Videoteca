package Comparators;

import Model.Pelicula;

import java.util.Comparator;

public class CompVotos implements Comparator<Pelicula>{

    @Override
    public int compare(Pelicula p1, Pelicula p2) { //compara si los votos de p1 y p2 son iguales
        if (p1.getVotos() ==  p2.getVotos()){      //si tienen el mismo num de votos se ordena por titulo
            return p1.getTitulo().compareTo(p2.getTitulo());
        }else {
            return p2.getVotos() - p1.getVotos();
        }
    }
}
