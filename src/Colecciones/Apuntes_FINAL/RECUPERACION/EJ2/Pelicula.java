package Colecciones.Apuntes_FINAL.RECUPERACION.EJ2;

import java.time.LocalDate;
import java.util.Objects;

public class Pelicula {

    //atributos
    private int id;
    private String director;
    private static int contador;
    private String titulo;
    private LocalDate fecha;
    private Tipo_Genero genero;
    private boolean disponible;

    //constructor
    public Pelicula(String titulo, String director, LocalDate fecha, Tipo_Genero genero, boolean disponible) {
        this.id = contador++;
        this.titulo = titulo;
        this.fecha = fecha;
        this.genero = genero;
        this.disponible = disponible;
        this.director = director;
    }

    //getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Pelicula.contador = contador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Tipo_Genero getGenero() {
        return genero;
    }

    public void setGenero(Tipo_Genero genero) {
        this.genero = genero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    //toString
    @Override
    public String toString() {
        return "Pelicula: " +
                "\n id=" + id +
                "\n titulo='" + titulo +
                "\n fecha=" + fecha +
                "\n genero=" + genero +
                "\n disponible=" + disponible +
                "\n director =" + director +
                "\n -----------------------------";
    }

    //equals y hashcode
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pelicula pelicula)) return false;
        return Objects.equals(director, pelicula.director) && Objects.equals(titulo, pelicula.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(director, titulo);
    }

}
