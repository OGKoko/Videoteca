package Model;

public class Pelicula {     //creamos una clase pelicula con sus respectivos atributos
    private String titulo;
    private String genero;
    private int votos;

    public Pelicula(String titulo, String genero, int votos) { //el constructor de la clase
        this.titulo = titulo;
        this.genero = genero;
        this.votos = votos;
    }
 //--------- sus getters & setters -----------------
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }
}
