package Colecciones.Boletin1.Ej2.Model;

import Colecciones.Boletin1.Ej2.Exceptions.DeportivosException;
import java.util.ArrayList;
import java.util.List;

public class Equipo {

    // ATRIBUTOS
    private String nombre;
    private List<Alumno> alumnos;

    // CONSTRUCTOR
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.alumnos = new ArrayList<>();
    }

    // MÉTODOS

    public void addAlumno(Alumno a) throws DeportivosException {
        if (alumnos.contains(a)) {
            throw new DeportivosException("El alumno ya está en el equipo.");
        }
        alumnos.add(a);
    }

    public void removeAlumno(Alumno a) throws DeportivosException {
        if (!alumnos.contains(a)) {
            throw new DeportivosException("El alumno no existe en el equipo.");
        }
        alumnos.remove(a);
    }

    public Alumno buscarAlumno(Alumno a) { //OJO
        boolean encontrado = false;
        Alumno a2 = null;
        int posicion = 0;

        if(alumnos.contains(a)){
            posicion = alumnos.indexOf(a);
            a2 = alumnos.get(posicion);
        }
        return a2;
    }

    public void mostrarEquipo() {
        System.out.println("Equipo " + nombre + ":");
        for (Alumno a : alumnos) {
            System.out.println(" - " + a);
        }
    }
    public Equipo union(Equipo otro) {
        Equipo resultado = new Equipo(this.nombre + " + " + otro.nombre); // ojo
        resultado.alumnos.addAll(this.alumnos);
        resultado.alumnos.addAll(otro.alumnos);
        return resultado;
    }

    public Equipo interseccion(Equipo otro) {
        Equipo resultado = new Equipo(this.nombre + " ∩ " + otro.nombre);
        for (Alumno a : this.alumnos) {
            if (otro.alumnos.contains(a)) {
                resultado.alumnos.add(a);
            }
        }
        return resultado;
    }

    // TOSTRING
    @Override
    public String toString() {
        return "Equipo: " + nombre + " | Miembros: " + alumnos.size();
    }

    // HASHCODE Y EQUALS
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Equipo e)) return false;
        return nombre.equalsIgnoreCase(e.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.toLowerCase().hashCode();
    }

    // GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
