package Colecciones.Boletin1.Modelo;

import java.util.Objects;

public class Estudiante {
    private String nombre;
    private int id;

    public Estudiante(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Estudiante that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
