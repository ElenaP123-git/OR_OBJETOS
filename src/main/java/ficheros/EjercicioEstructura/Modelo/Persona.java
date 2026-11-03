package ficheros.EjercicioEstructura.Modelo;

import java.util.List;
import java.util.Objects;

public class Persona {
    
    // 1. ATRIBUTOS
    private String nombre;
    private List<Double> notas;

    // 2. CONSTRUCTOR
    public Persona(String nombre, List<Double> notas) {
        this.nombre = nombre;
        this.notas = notas;
    }

    // 3. GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    // 4. EQUALS Y HASHCODE (para comparar personas por su nombre)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(nombre, persona.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    // 5. TOSTRING
    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", notas=" + notas + "]";
    }
}
