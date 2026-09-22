package Colecciones.Apuntes_FINAL.RECUPERACION.EJ6.EXCEPTIONS;

public class EmailExisteException extends RuntimeException {
    public EmailExisteException(String message) {
        super(message);
    }
}
