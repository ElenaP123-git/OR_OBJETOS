package Orientacion_Obj.BoletinFinal.Boletin9.Ej3;

public class GestionaFactoria {
    public static void main(String[] args) {

        //creo lista
        Robot inventarioRobots [] = new Robot[20];

        //creo robots
        Robot r1P = new Pintor("R11",100,"electrico","Muy chulo");
        Robot r1R = new Soldador("R22", 9, "electrico","No tan chulo", 13.4, "Seguro");
        Robot r1E = new Ensamblador("R33", 50, "gasolina", "Está bien");
        Robot r2P = new Pintor("R12",10,"electrico","Muy good");

        // Creo un array con los robots que quiero meter
        Robot[] robotsCreados = { r1P, r1R, r1E, r2P };

        // Los meto en inventario con un for
        for (int i = 0; i < robotsCreados.length; i++) {
            inventarioRobots[i] = robotsCreados[i];
        }
        //recorro inventario
        for (Robot r: inventarioRobots){
            if(r != null){
                System.out.println(r);
            }
        }
    }
}
