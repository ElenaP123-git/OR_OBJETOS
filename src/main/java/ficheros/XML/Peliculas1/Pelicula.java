package ficheros.XML.Peliculas1;

import java.util.Objects;

public class Pelicula {

	//ATRIBUTOS
    private String titulo;
    private String duracion;
    private String genero;
    private String sinopsis;
    private String fecha;
    private String director;

    //CONSTRUCTORES
    public Pelicula() {
    }

    public Pelicula(String titulo, String fecha, String director) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.director = director;
    }

    public Pelicula(String titulo, String duracion, String genero, String sinopsis, String fecha, String director) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.fecha = fecha;
        this.director = director;
    }

    //GETTERS Y SETTERS
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    //EQUALS Y HASHCODE
    @Override
    public int hashCode() {
        return Objects.hash(director, duracion, fecha, genero, sinopsis, titulo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Pelicula other = (Pelicula) obj;
        return Objects.equals(director, other.director)
                && Objects.equals(duracion, other.duracion)
                && Objects.equals(fecha, other.fecha)
                && Objects.equals(genero, other.genero)
                && Objects.equals(sinopsis, other.sinopsis)
                && Objects.equals(titulo, other.titulo);
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Pelicula [titulo=" + titulo + ", fecha=" + fecha + ", director=" + director + "]";
    }
}
