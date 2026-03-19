package Colecciones.Boletin2;

import java.util.TreeSet;

public class RepositorioAnimal {
    // ATRIBUTOS

    private String nombre;
    private String lugar;
    private double presupuestoAnual;
    private TreeSet<Animal> animales;

    // CONSTRUCTOR

    public RepositorioAnimal(String nombre, String lugar, double presupuestoAnual) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.presupuestoAnual = presupuestoAnual;
        this.animales = new TreeSet<>(new ComparadorAnimal());
    }

    // MÉTODOS

    public boolean agregarAnimal(Animal a) {
        return animales.add(a); // evita duplicados por ID
    }

    public void mostrarAnimales() {
        for (Animal a : animales) {
            System.out.println("Nombre: " + a.getNombre());
            System.out.println("Fecha nacimiento: " + a.getFechaNacimiento());
            System.out.println("Medio: " + a.getMedio());
            System.out.println("Alimentación: " + a.getClasificacionComida());
            System.out.println("-------------------------");
        }
    }
}

