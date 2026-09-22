package Colecciones.Boletin1.Ej2.Model;

import java.util.Objects;

public class Alumno {

    // ATRIBUTOS
    private String nombre;
    private String dni;

    // CONSTRUCTOR
    public Alumno(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    // TOSTRING
    @Override
    public String toString() {
        return nombre + " (" + dni + ")";
    }

    // HASHCODE Y EQUALS
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Alumno a)) return false;
        return Objects.equals(dni, a.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    // GETTERS Y SETTERS
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
}


