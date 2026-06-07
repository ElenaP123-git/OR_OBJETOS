package Colecciones.Apuntes_FINAL.RECUPERACION.EJ8.EXCEPTIONS;

public class ClienteYaExistenteException extends RuntimeException {
    public ClienteYaExistenteException(String message) {
        super(message);
    }
}
