package Excepciones.Apuntes_FINAL.Ej1.Exceptions;

public class StockInvalidoException extends RuntimeException {
    public StockInvalidoException(String message) {
        super(message);
    }
}
