package Ejercicio1;

import org.example.Ejercicio1.GestorPedidos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestPedidosTest {

    // calculo nomal met1
    @Test
    void calcularPrecioFinalNormal(){
        GestorPedidos g = new GestorPedidos();
        double resultado = g.calcularPrecioFinal(100,1);
        assertEquals(99, resultado);
    }

    //descuento > 50 met1
    @Test
    void testDescuentoMayorDe50(){
        GestorPedidos g = new GestorPedidos();
        double resultado = g.calcularPrecioFinal(100,80);
        assertEquals(50,resultado);
    }

    //descuento = 0
    @Test
    void testDescuento0(){
        GestorPedidos g = new GestorPedidos();
        double resultado = g.calcularPrecioFinal(100,0);
        assertEquals(100,resultado);
    }

    //valores negativos dan excepcion met 1
    @Test
    void testPreciosNegativosSonExcepcion(){
        GestorPedidos g = new GestorPedidos();
        assertThrows(IllegalArgumentException.class, () -> g.calcularPrecioFinal(-10,10));
    }

    @Test
    void testDescuentoNegativoEsExcepcion(){
        GestorPedidos g = new GestorPedidos();
        assertThrows(IllegalArgumentException.class, () -> g.calcularPrecioFinal(10,-5));
    }

    //met 2
    @Test
    void testPedidoNegativo(){
        GestorPedidos g = new GestorPedidos();
        String resultado = g.clasificarPedido(-3);
        assertEquals("ERROR", resultado);
    }

    @Test
    void testPedidoGrande(){
        GestorPedidos g = new GestorPedidos();
        String resultado = g.clasificarPedido(60);
        assertEquals("GRANDE", resultado);
    }

    @Test
    void testPedido0(){
        GestorPedidos g = new GestorPedidos();
        String resultado = g.clasificarPedido(0);
        assertEquals("VACIO", resultado);
    }

    @Test
    void testPedidoPequeño(){
        GestorPedidos g = new GestorPedidos();
        String resultado = g.clasificarPedido(5);
        assertEquals("PEQUEÑO", resultado);
    }

    @Test
    void testPedidoMediano(){
        GestorPedidos g = new GestorPedidos();
        String resultado = g.clasificarPedido(45);
        assertEquals("MEDIANO", resultado);
    }

    //met3
    @Test
    void testUrgente(){
        GestorPedidos g = new GestorPedidos();
        boolean resultado= g.esUrgente(10);
        assertTrue(resultado);
    }

    @Test
    void testNoUrgente(){
        GestorPedidos g = new GestorPedidos();
        boolean resultado = g.esUrgente(60);
        assertFalse(resultado);
    }

}