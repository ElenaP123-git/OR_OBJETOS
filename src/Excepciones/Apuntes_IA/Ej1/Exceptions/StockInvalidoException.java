package Excepciones.Apuntes_IA.Ej1.Exceptions;

public class StockInvalidoException extends RuntimeException {
    public StockInvalidoException(String message) {
        super(message);
    }
}
