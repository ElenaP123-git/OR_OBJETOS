package Excepciones.boletin2.Ej2.Models;

import Excepciones.boletin2.Ej2.Exceptions.CocinaException;

public class Recetario {

    //atributos
    private Receta [] recetas;
    private int numRecetas;

    //constructor
    public Recetario() {
        this.recetas = new Receta[50];
    }

    //métodos

    public boolean addReceta(Receta r){
        if (numRecetas >= recetas.length){
            return false;
        }
        else{
            recetas[numRecetas] = r;
            numRecetas++;
            return true;
        }
    }

    public Receta buscar(String nombre) throws CocinaException {

            for (int i = 0; i < numRecetas; i++) {

                // si NO coincide el nombre, seguimos (de otra manera me da error)
                if (!recetas[i].getNombre().equalsIgnoreCase(nombre)) {
                    continue;
                }

                // si coincide, de lujo, pa lante
                return recetas[i];
            }

            // si termina el bucle sin encontrarla, lanzo la excepción (esto pasa cuando receta es null)
            throw new CocinaException("\nLa receta " + nombre + " no existe en el recetario");
        }

    }
