package Excepciones.Clase;

/**
 * Clase que contiene un método que valida si un número es par.
 * Si es impar, lanza la excepción ExceptionEJ.
 */

public class ValidarExcep {

    public void metodo1(int n) throws ExceptionEJ { // trows avisa que se va a usar una excepción

        if (n % 2 != 0) {
            throw new ExceptionEJ(n); //trow new tira la excepción (se debe utlizar su constructor)
        }
        System.out.println("El número " + n + " es par.");
    }
}

