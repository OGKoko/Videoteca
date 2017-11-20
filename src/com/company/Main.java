package com.company;

import Comparators.CompGenero;
import Comparators.CompVotos;
import Model.Pelicula;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        public static void main(String[] args) throws IOException{
        int opcion;
        boolean salir = false;
        boolean datos = false;

        ArrayList<Pelicula> peliculas = new ArrayList<>();

        do {
            System.out.println("---------------MENU--------------");
            System.out.println("1 cargar datos de inicio---------");
            System.out.println("2 Peliculas ordenadas por votos--");
            System.out.println("3 peliculas ordenadas por genero-");
            System.out.println("4 salir -------------------------");
            opcion =pedirNum();

            try {
                switch (opcion) {
                    case 1:
                        if (!datos) {
                            CargarDatos(peliculas);
                            datos = true;
                            System.out.println("datos cargados al 100%");
                        } else {
                            System.out.println("los datos ya habian sido cargados :)");
                        }
                        break;
                    case 2:
                        CompVotos compVotos = new CompVotos();
                        Collections.sort(peliculas, compVotos);
                        System.out.println("Orden segun numero de votos: ");
                        for (Pelicula auxPelicula : peliculas) {
                            System.out.println("numero de votos: " + auxPelicula.getVotos() + " Titulo: " + auxPelicula.getTitulo());
                        }
                        break;
                    case 3:
                        CompGenero compGen = new CompGenero();
                        Collections.sort(peliculas, compGen);
                        System.out.println("Orden segun el genero: ");
                        for (Pelicula auxPelicula : peliculas) {
                            System.out.println("Genero: " + auxPelicula.getGenero() + " Titulo: " + auxPelicula.getTitulo() + " numero de votos: " + auxPelicula.getVotos());
                        }
                        break;
                    case 4:
                        System.out.println("See you Later!");
                        salir = true;
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("introduce un NUMERO >:( ");
            }
        }while (!salir);
    }


    public static void CargarDatos(ArrayList<Pelicula> peliculas) throws IOException{               //este metodo cargará los datos iniciales en el arraylist

        try {
            BufferedReader brVideoclub = new BufferedReader(new FileReader("videoteca.dat"));
            String texto;
            Pelicula auxPelicula;

            brVideoclub.readLine();

            while ((texto = brVideoclub.readLine()) != null) {
                String espacio[] = texto.split(";");
                auxPelicula = new Pelicula(espacio[0], espacio[1], Integer.parseInt(espacio[2]));
                peliculas.add(auxPelicula);
            }
        }catch (IOException e){
            System.out.println("ha habido un problema con la lectura del archivo");
        }catch (Exception e){
            System.out.println("Ha ocurrido algun error con el archivo");
        }
    }

    public static int pedirNum() throws IOException{ //este metodo servira para comprobar que el caracter introducido es valido
            String num;
            while (true){
                num=br.readLine();
                if (num.matches("[0-9]*")){
                    return Integer.parseInt(num);

                }else{
                    System.out.println("dame un numero >:(");
                }
            }
    }
}
