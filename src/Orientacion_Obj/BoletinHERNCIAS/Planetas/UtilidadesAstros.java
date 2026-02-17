package Orientacion_Obj.BoletinHERNCIAS.Planetas;

public class UtilidadesAstros {

    public static void muestraInformación(Astro a) {

        a.muestra(); // cuando ya hago la función, lo identifico :)

        if (a instanceof Planeta) {
            System.out.println("Es un planeta.");
        }
        else if (a instanceof Satelite) {
            System.out.println("Es un satélite.");
        }
        else {
            System.out.println("Es un astro genérico.");
        }
    }
}

