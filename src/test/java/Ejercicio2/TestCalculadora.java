package Ejercicio2;

import org.example.Ejercicio2.CalculadoraEnvios;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestCalculadora {

    //METODO 1

    @ParameterizedTest
    @CsvSource({
            "2,3,true,6.53",
            "3,2, false,7.26"
    })
    void testCalculoTotal(double unidad1, int unidad2, boolean iva, double esperado){
        CalculadoraEnvios c = new CalculadoraEnvios();
        assertEquals(esperado, c.calcularTotal(unidad1,unidad2,iva));
    }

    @Test
    void testCalculoError(){
        CalculadoraEnvios c = new CalculadoraEnvios();
        assertThrows(IllegalArgumentException.class, () -> c.calcularTotal(-1,-2, false));
    }

    //METODO 2

    @ParameterizedTest
    @CsvSource({
            "-2, ERROR",
            "0, VACIO",
            "4, PEQUEÑO",
            "10, MEDIO",
            "30, GRANDE"
    })
    void testCantidad(int unidad, String esperado){
        CalculadoraEnvios c = new CalculadoraEnvios();
        assertEquals(esperado, c.clasificarCantidad(unidad));
    }

    //METODO 3 ( no se )

    @ParameterizedTest
    @CsvSource({
            "'1-2-3', 2.00",
            "'5', 5.00",
            "'10-20-30', 20.00"
    })
    void testPromedioParametrizado(String datos, double esperado) {
        CalculadoraEnvios c = new CalculadoraEnvios();

        // Convertimos la cadena "1-2-3" en un array double[]
        String[] partes = datos.split("-");
        double[] array = new double[partes.length];

        for (int i = 0; i < partes.length; i++) {
            array[i] = Double.parseDouble(partes[i]);
        }

        assertEquals(esperado, c.promedio(array));
    }

    @Test
    void testPromedioNegativoExcepcion() {
        CalculadoraEnvios c = new CalculadoraEnvios();
        double[] datos = {1, -2, 3};
        assertThrows(IllegalArgumentException.class, () -> c.promedio(datos));
    }

    @Test
    void testPromedioArrayVacioExcepcion() {
        CalculadoraEnvios c = new CalculadoraEnvios();
        double[] datos = {};
        assertThrows(IllegalArgumentException.class, () -> c.promedio(datos));
    }
                            //o tambien...
    @Test
    void testPromedioNullExcepcion() {
        CalculadoraEnvios c = new CalculadoraEnvios();
        assertThrows(IllegalArgumentException.class, () -> c.promedio(null));
    }
    //METODO 4

    @ParameterizedTest
    @CsvSource({
            "90, 5, false, false", //no se cumple ninguna
            "110, 20, true, true", //se cumplen todas
            "200, 30, false, true" //se cumple 1
    })
    void testEsPremium(double u, int u2, boolean vip, boolean esperado){
        CalculadoraEnvios c = new CalculadoraEnvios();
        assertEquals(esperado, c.esPremium(u, u2,vip));
    }
}
