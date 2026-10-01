package ej4.Model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Encuentro {
	
	//ATRIBUTOS
	private String nombre;
    private LocalDate fecha;
    private int dificultad;
    private List<String> enemigos;

    //CONSTRUCTOR
    public Encuentro(String nombre, LocalDate fecha, int dificultad, List<String> enemigos) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.dificultad = dificultad;
        this.enemigos = (enemigos != null) ? new ArrayList<>(enemigos) : new ArrayList<>();
    }

    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public List<String> getEnemigos() {
        List<String> copia = new ArrayList<>(enemigos);
        return copia;
    }

    public void setEnemigos(List<String> enemigos) {
        this.enemigos = (enemigos != null) ? new ArrayList<>(enemigos) : new ArrayList<>();
    }

    //EQUALS Y HASHCODE 
    @Override
    public boolean equals(Object obj) {
        boolean esIgual = false;
        if (this == obj) {
            esIgual = true;
        } else if (obj != null && getClass() == obj.getClass()) {
            Encuentro other = (Encuentro) obj;
            esIgual = Objects.equals(nombre, other.nombre);
        }
        return esIgual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    //TOSTRING
    @Override
    public String toString() {
        return "\n    Encuentro: " + nombre + " [Fecha=" + fecha + ", Dificultad=" + dificultad + ", Enemigos=" + enemigos + "]";
    }
}
