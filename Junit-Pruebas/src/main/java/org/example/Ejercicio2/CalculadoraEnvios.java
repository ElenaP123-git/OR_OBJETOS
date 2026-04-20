package org.example.Ejercicio2;

public class CalculadoraEnvios {

        // Método 1

        public double calcularTotal(double precioUnidad, int cantidad, boolean tieneDescuento) {
            if (precioUnidad <= 0 || cantidad <= 0) {
                throw new IllegalArgumentException("Valores inválidos");
            }

            double subtotal = precioUnidad * cantidad;

            if (tieneDescuento) {
                subtotal *= 0.90; // 10% descuento
            }

            double totalConIVA = subtotal * 1.21; // IVA del 21%

            return Math.round(totalConIVA * 100.0) / 100.0; // redondeo a 2 decimales
        }


        // Método 2

        public String clasificarCantidad(int cantidad) {
            if (cantidad < 0) return "ERROR";
            if (cantidad == 0) return "VACIO";
            if (cantidad < 5) return "PEQUEÑO";
            if (cantidad < 20) return "MEDIO";
            return "GRANDE";
        }


        // Método 3

        public double promedio(double[] precios) {
            if (precios == null || precios.length == 0) {
                throw new IllegalArgumentException("Array vacío");
            }

            double suma = 0;
            for (double p : precios) {
                if (p < 0) throw new IllegalArgumentException("Precio negativo");
                suma += p;
            }

            return Math.round((suma / precios.length) * 100.0) / 100.0;
        }


        // Método 4

        public boolean esPremium(double total, int cantidad, boolean esVIP) {
            return total > 100 || cantidad > 10 || esVIP;
        }
    }


