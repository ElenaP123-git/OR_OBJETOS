package Excepciones.Clase;

/**
 * Clase principal que prueba el método y captura la excepción.
 */

public class GestionMain {

    public static void main(String[] args) {

        // Crear objeto para usar el método que puede lanzar la excepción
        ValidarExcep v = new ValidarExcep();

        try {
            // Llamada al método con un número impar → lanza excepción
            v.metodo1(7);
        }
        catch (ExceptionEJ e) {
            // Se ejecuta si ocurre la excepción
            System.out.println(e);  // Muestra el mensaje del toString()
        }

        System.out.println("Programa terminado.");
    }
}


