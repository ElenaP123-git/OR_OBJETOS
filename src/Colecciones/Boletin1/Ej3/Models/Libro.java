package Colecciones.Boletin1.Ej3.Models;

import Colecciones.Boletin1.Ej3.Exceptions.BibliotecaException;

public class Libro {

    // ATRIBUTOS
    private String titulo;
    private String autor;
    private String genero;
    private int anio;
    private int ejemplaresLibres;
    private int ejemplaresPrestados;

    // CONSTRUCTOR
    public Libro(String titulo, String autor, String genero, int anio, int ejemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anio = anio;
        this.ejemplaresLibres = ejemplares;
        this.ejemplaresPrestados = 0;
    }

    // MÉTODOS
    public void prestar() throws BibliotecaException {
        if (ejemplaresLibres == 0) {
            throw new BibliotecaException("No hay ejemplares disponibles.");
        }
        ejemplaresLibres--;
        ejemplaresPrestados++;
    }

    public void devolver() throws BibliotecaException {
        if (ejemplaresPrestados == 0) {
            throw new BibliotecaException("No hay ejemplares prestados.");
        }
        ejemplaresPrestados--;
        ejemplaresLibres++;
    }

    // TOSTRING
    @Override
    public String toString() {
        return titulo + " - " + autor + " (" + anio + ")";
    }

    // GETTERS
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getGenero() { return genero; }
    public int getAnio() { return anio; }
    public int getEjemplaresLibres() { return ejemplaresLibres; }
    public int getEjemplaresPrestados() { return ejemplaresPrestados; }
}
