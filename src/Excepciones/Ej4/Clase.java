package Excepciones.Ej4;

import java.util.Random;

public class Clase {

    Random r = new Random();

    public void hacerDivisiones(){
      double [] tabla = new double[20];
      for(int i = 0; i < 20; i++){
          int num1 = r.nextInt(11);
          int num2 = r.nextInt(11);

          try{
              double resultado = num1/num2;
              tabla[i] = resultado;
          }
          catch (ArithmeticException e){
              System.out.println("No se puede dividir entre 0");
          }
          catch(ArrayIndexOutOfBoundsException e){
              System.out.println("Intentando guardar en la posición 10");
          }
      }
        System.out.println("Proceso terminado");
    }
}
