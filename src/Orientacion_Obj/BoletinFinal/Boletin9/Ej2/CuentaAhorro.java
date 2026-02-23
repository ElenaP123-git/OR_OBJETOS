package Orientacion_Obj.BoletinFinal.Boletin9.Ej2;

public class CuentaAhorro extends CuentaBancaria{

    private static final double saldoMinimo = 1000;

        public CuentaAhorro(String iban, double saldo) {
            super(iban, saldo);
        }

        @Override
        public void calcularIntereses() {

            double interes;

            if (saldo < saldoMinimo) {
                interes = saldo * (interesAnualBasico / 2);
            } else {
                interes = saldo * (interesAnualBasico * 2);
            }

            saldo += interes;
        }
    }

