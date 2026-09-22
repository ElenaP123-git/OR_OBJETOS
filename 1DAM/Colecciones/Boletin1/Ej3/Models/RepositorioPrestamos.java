package Colecciones.Boletin1.Ej3.Models;

import Colecciones.Boletin1.Ej3.Exceptions.BibliotecaException;

import java.util.LinkedHashSet;

public class RepositorioPrestamos {


    // ATRIBUTOS

    private LinkedHashSet<Prestamo> prestamos;
    private int id;
    private static int contadorId;


    // CONSTRUCTOR

    public RepositorioPrestamos() {
        prestamos = new LinkedHashSet<>();
        this.id = contadorId++;
    }


    // MÉTODOS

    public void agregarPrestamo(Libro libro, String usuario) {

        try {
            libro.prestar(); // si ya está prestado lanza excepción
            Prestamo p = new Prestamo(id,libro,usuario);
            prestamos.add(p);
        } catch (BibliotecaException e) {
            System.out.println("No es posible realizar el préstamo de un libro que ya está prestado.");
        }
    }


    public void devolverPrestamo(Libro libro) {

        try {
            libro.devolver();
            System.out.println("Libro devuelto correctamente.");

        } catch (BibliotecaException e) {
            System.out.println("No es posible devolver un libro que no está prestado.");
        }
    }


    public void mostrarHistorial() {
        for (Prestamo p : prestamos) {
            System.out.println(p);
        }
    }


    public void buscarPrestamosLibro(String titulo, String autor) {
        for (Prestamo p : prestamos) {
            if (p.getLibro().getTitulo().equalsIgnoreCase(titulo) &&
                    p.getLibro().getAutor().equalsIgnoreCase(autor)) {
                System.out.println(p);
            }
        }
    }
}

