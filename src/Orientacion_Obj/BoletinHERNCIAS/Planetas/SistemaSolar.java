package Orientacion_Obj.BoletinHERNCIAS.Planetas;

public class SistemaSolar {

    public static void main(String[] args) {

        Planeta tierra = new Planeta("Tierra", 5.97e24, 12742,
                24, 365*24, 149_600_000, 5);

        Satelite luna = new Satelite("Luna", 7.35e22, 3474,
                655, 655, 384_400, tierra);

        tierra.addSatelite(luna);

        UtilidadesAstros.muestraInformación(tierra);
        System.out.println();
        UtilidadesAstros.muestraInformación(luna);
    }
}
