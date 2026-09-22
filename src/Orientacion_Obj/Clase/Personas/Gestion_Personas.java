package Orientacion_Obj.Clase.Personas;

public class Gestion_Personas {
    public static void main(String[] args) {
        Persona pepito = new Persona(19, "Pepe", "La Rinconada", "Lord of Rings", "Programador","Magic");
        System.out.println(pepito.toString());
        pepito.hablar();

        Persona paula = new Persona(); // esto se usa cuando no sabes aun todos los datos de la persona
        paula.nombre = "Paula";
        System.out.println(paula.toString());
        paula.comer();
    }
}
