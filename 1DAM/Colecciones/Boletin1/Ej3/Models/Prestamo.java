package Colecciones.Boletin1.Ej3.Models;

import java.time.LocalDate;
import java.util.Objects;

public class Prestamo {

    
    // ATRIBUTOS
    
    private int id;
    private Libro libro;
    private String nombreUsuario;   // DNI del usuario
    private LocalDate fechaPrestamo;

    
    // CONSTRUCTOR
    
    public Prestamo(int id, Libro libro, String nombreUsuario) {
        this.id = id;
        this.libro = libro;
        this.nombreUsuario = nombreUsuario;
        this.fechaPrestamo = LocalDate.now();
    }

    
    // GETTERS
    
    public int getId() { return id; }
    public Libro getLibro() { return libro; }
    public String getNombreUsuario() { return nombreUsuario; }
    public LocalDate getFechaPrestamo() { return fechaPrestamo; }

    
    // EQUALS & HASHCODE
    
    // Dos préstamos son iguales si: mismo título, mismo autor, misma fecha y mismo usuario
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Prestamo p)) return false;

        return libro.getTitulo().equalsIgnoreCase(p.libro.getTitulo()) &&
                libro.getAutor().equalsIgnoreCase(p.libro.getAutor()) &&
                fechaPrestamo.equals(p.fechaPrestamo) &&
                nombreUsuario.equalsIgnoreCase(p.nombreUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                libro.getTitulo().toLowerCase(),
                libro.getAutor().toLowerCase(),
                fechaPrestamo,
                nombreUsuario.toLowerCase()
        );
    }

    
    // TOSTRING
    
    @Override
    public String toString() {
        return "Préstamo " + id + ": " + libro.getTitulo() + " - " + libro.getAutor() +
                " | Usuario: " + nombreUsuario +
                " | Fecha: " + fechaPrestamo;
    }
}


