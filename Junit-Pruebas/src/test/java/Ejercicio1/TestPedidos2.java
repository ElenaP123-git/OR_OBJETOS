package Ejercicio1;

import org.example.Ejercicio1.GestorPedidos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestPedidos2 {

    //met 2
    @ParameterizedTest
    @CsvSource({
            "-3, ERROR",
            "0, VACIO",
            "5, PEQUEÑO",
            "45, MEDIANO",
            "60, GRANDE"
    })
    void testClasificarPedidoParametrizado(int unidades, String esperado){
        GestorPedidos g =  new GestorPedidos();
        assertEquals(esperado, g.clasificarPedido(unidades));
    }

    //met3
    @ParameterizedTest
    @CsvSource({
            "10, true",
            "60, false"
    })
    void testEsUrgenteParametrizado(int unidades, boolean esperado){
        GestorPedidos g = new GestorPedidos();
        assertEquals(esperado, g.esUrgente(unidades));
    }

    //met1
    @ParameterizedTest
    @CsvSource({
            "100,1,99",
            "100,0, 100",
            "100,80, 50" // SE PONE DOUBLE PORQUE ES LO QUE RECIBE EL METODO
    })
    void testCalcularPrecioFinalParametrizado(double unidades, double descuento, double esperado){
        GestorPedidos g = new GestorPedidos();
        assertEquals(esperado, g.calcularPrecioFinal(unidades,  descuento));
    }

    @Test
    void testPrecioNegativoExcepcion() {
        GestorPedidos g = new GestorPedidos();
        assertThrows(IllegalArgumentException.class, () -> g.calcularPrecioFinal(-10, 10)); //LAS EXCEPCIONES A PARTE
    }

    @Test
    void testDescuentoNegativoExcepcion() {
        GestorPedidos g = new GestorPedidos();
        assertThrows(IllegalArgumentException.class, () -> g.calcularPrecioFinal(10, -5));
    }

}
