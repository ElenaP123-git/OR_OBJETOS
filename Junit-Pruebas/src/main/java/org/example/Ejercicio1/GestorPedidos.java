package org.example.Ejercicio1;

public class GestorPedidos {

    public double calcularPrecioFinal(double precioBase, double descuento) {
        if (precioBase < 0 || descuento < 0) {
            throw new IllegalArgumentException("Valores negativos no permitidos");
        }
        if (descuento > 50) {
            descuento = 50; // máximo 50%
        }
        return precioBase - (precioBase * descuento / 100);
    }

    public String clasificarPedido(int unidades) {
        if (unidades < 0) {
            return "ERROR";
        } else if (unidades == 0) {
            return "VACIO";
        } else if (unidades < 10) {
            return "PEQUEÑO";
        } else if (unidades < 50) {
            return "MEDIANO";
        } else {
            return "GRANDE";
        }
    }

    public boolean esUrgente(int horasRestantes) {
        return horasRestantes <= 24;
    }
}

