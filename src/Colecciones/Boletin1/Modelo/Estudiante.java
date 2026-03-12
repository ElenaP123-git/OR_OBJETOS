package Colecciones.Boletin1.Modelo;

import Colecciones.Boletin1.Exceptions.EstudianteNoEncontradoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Estudiante {


    // ATRIBUTOS

    private String nombre;
    private String id;
    private List<Double> notas;


    // CONSTRUCTOR

    public Estudiante(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.notas = new ArrayList<>();
    }


    // MÉTODOS

    public void agregarNota(double nota) {
        notas.add(nota);
    }

    public double calcularPromedio() throws EstudianteNoEncontradoException {
        if (notas.isEmpty()) { // :)
            throw new EstudianteNoEncontradoException("El estudiante no tiene notas registradas.");
        }
        double suma = 0;
        for (double n : notas) suma += n;
        return suma / notas.size();
    }


    // GETTERS Y SETTERS

    public String getNombre() { return nombre; }
    public String getId() { return id; }
    public List<Double> getNotas() { return notas; }


    // TOSTRING

    @Override
    public String toString() {
        return nombre + " (" + id + ") Notas: " + notas;
    }

    //HASHCODE Y EQUALS

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Estudiante that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

