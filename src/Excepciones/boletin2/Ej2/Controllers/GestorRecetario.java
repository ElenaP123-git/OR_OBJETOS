package Excepciones.boletin2.Ej2.Controllers;

import Excepciones.boletin2.Ej2.Exceptions.CocinaException;
import Excepciones.boletin2.Ej2.Models.Receta;
import Excepciones.boletin2.Ej2.Models.Recetario;

public class GestorRecetario {
    public static void main(String[] args) {

        // creo recetas
        Receta r1 = new Receta("Pasta");
        Receta r2 = new Receta("Ensalada");

        // añado ingredientes
        r1.addIngrediente("Pasta", 100);
        r1.addIngrediente("Tomate", 50);

        r2.addIngrediente("Lechuga", 30);
        r2.addIngrediente("Tomate", 20);

        // creo un recetario y añado las recetas
        Recetario recetario = new Recetario();

        recetario.addReceta(r1);
        recetario.addReceta(r2);

        // EL EXCEPTION (aqui pongo los métodos que tiran la excepción)

        // Caso 1: bien :)
        try {
            recetario.buscar("Pasta").cocinar(3); //pongo juntos los dos métodos porque usan la misma excepción
        } catch (CocinaException e) {                               // esto es lo mismo que Receta r = recetario.buscar("Pasta"); r.cocinar(3);
            System.out.println(e);
        }

        // Caso 2: comensales inválidos
        try {
            recetario.buscar("Ensalada").cocinar(0);
        } catch (CocinaException e) {
            System.out.println(e);
        }

        // Caso 3: comensales demasiado altos ("CocinaException: número de comensales inválido")
        System.out.println("\n");

        try {
            recetario.buscar("Pasta").cocinar(2000);
        } catch (CocinaException e) {
            System.out.println(e);
        }

        // Caso 4: receta no existe (CocinaException: La receta Tarta no existe en el recetario)
        System.out.println("\n");

        try {
            recetario.buscar("Tarta").cocinar(2);
        } catch (CocinaException e) {
            System.out.println(e);
        }
        System.out.println("\nHoli, yo sigo por aquí siempre PORQUE SOY FINALBATMAN");
    }

}
