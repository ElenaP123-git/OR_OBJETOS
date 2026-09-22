package Colecciones.Boletin1.Ej3.Models;

import Colecciones.Boletin1.Ej3.Exceptions.BibliotecaException;
import java.util.ArrayList;

public class Biblioteca {

    // ATRIBUTOS
    private ArrayList<Libro> libros;
    private RepositorioPrestamos repoP;

    // CONSTRUCTOR
    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.repoP = new RepositorioPrestamos();
    }

    // MÉTODOS
    public void agregarLibro(Libro l) {
        libros.add(l);
    }

    public Libro buscarPorTitulo(String titulo) {

        int i = 0;
        boolean encontrado = false;
        Libro resultado = null;

        while (i < libros.size() && !encontrado) {

            if (libros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                encontrado = true;
                resultado = libros.get(i);
            } else {
                i++;
            }
        }

        return resultado;
    }

    public Libro buscarPorAutor(String autor) {

        int i = 0;
        boolean encontrado = false;
        Libro resultado = null;

        while (i < libros.size() && !encontrado) {

            if (libros.get(i).getAutor().equalsIgnoreCase(autor)) {
                encontrado = true;
                resultado = libros.get(i);
            } else {
                i++;
            }
        }

        return resultado;
    }


    public void prestarLibro(String titulo, String usuario) {
        Libro l = buscarPorTitulo(titulo);
        if (l == null) {
            System.out.println("El libro no está en el inventario.");
        } else {
            repoP.agregarPrestamo(l, usuario);
        }
    }


    public void devolverLibro(String titulo) {
        Libro l = buscarPorTitulo(titulo);
        if (l == null) {
            System.out.println("El libro no está en el inventario.");
        } else {
            repoP.devolverPrestamo(l);
        }
    }


    public void mostrarInventario() {
        for (Libro l : libros) {
            System.out.println(" - " + l);
        }
    }

    public void mostrarInfo(String titulo) {
        Libro l = buscarPorTitulo(titulo);

        if (l == null) {
            System.out.println("El libro no existe.");
        }
        else {
            System.out.println("\nTítulo: " + l.getTitulo());
            System.out.println("Autor: " + l.getAutor());
            System.out.println("Género: " + l.getGenero());
            System.out.println("Año: " + l.getAnio());
            System.out.println("Ejemplares libres: " + l.getEjemplaresLibres());
            System.out.println("Ejemplares prestados: " + l.getEjemplaresPrestados());
        }
    }

    //GETTERS Y SETTERS

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public RepositorioPrestamos getRepoP() {
        return repoP;
    }

    public void setRepoP(RepositorioPrestamos repoP) {
        this.repoP = repoP;
    }
}

