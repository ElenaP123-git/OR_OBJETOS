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

                // condición contraria: si NO coincide el nombre, seguimos
                if (!recetas[i].getNombre().equalsIgnoreCase(nombre)) {
                    continue;
                }

                // si coincide, la devolvemos
                return recetas[i];
            }

            // si termina el bucle sin encontrarla, lanzamos tu excepción
            throw new CocinaException("\nLa receta " + nombre + " no existe en el recetario");
        }

    }
