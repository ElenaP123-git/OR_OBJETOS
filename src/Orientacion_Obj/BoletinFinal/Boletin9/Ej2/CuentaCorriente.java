package Orientacion_Obj.BoletinFinal.Boletin9.Ej2;

public class CuentaCorriente extends CuentaBancaria{

        public CuentaCorriente(String iban, double saldo) {
            super(iban, saldo);
        }

        @Override
        public void calcularIntereses() {
            double interes = saldo * interesAnualBasico;
            saldo += interes;
        }
    }


