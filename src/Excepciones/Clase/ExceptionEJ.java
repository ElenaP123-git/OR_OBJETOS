package Excepciones.Clase;

 // Excepción personalizada que se lanza cuando el número recibido es impar.

public class ExceptionEJ extends Exception {

    // Atributo que guarda el número que causó la excepción

    private int numero;


     //Constructor que recibe el número problemático.

    public ExceptionEJ(int numero) {
        this.numero = numero;
    }


     // Mensaje que se mostrará cuando la excepción sea capturada.

    @Override
    public String toString() {
        return "ERROR: el número " + numero + " es impar";
    }
}

