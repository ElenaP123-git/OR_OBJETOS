package Colecciones.Boletin2.Ej1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
            System.out.println();
            System.out.println("Nombre: " + a.getNombre());
            System.out.println("Fecha nacimiento: " + a.getFechaNacimiento());
            System.out.println("Medio: " + a.getMedio());
            System.out.println("Alimentación: " + a.getClasificacionComida());
            System.out.println("-------------------------");
        }
    }

    public List<Animal> treeAList(){
        List<Animal> animalList1 = new ArrayList<>();
        Iterator<Animal> animalIterator = this.animales.iterator();

        do{
            Animal a = animalIterator.next();
            animalList1.add(a);
        } while (animalIterator.hasNext());

        return animalList1;
    }

    //GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public double getPresupuestoAnual() {
        return presupuestoAnual;
    }

    public void setPresupuestoAnual(double presupuestoAnual) {
        this.presupuestoAnual = presupuestoAnual;
    }

    public TreeSet<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(TreeSet<Animal> animales) {
        this.animales = animales;
    }
}

