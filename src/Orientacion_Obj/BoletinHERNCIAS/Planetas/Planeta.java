package Orientacion_Obj.BoletinHERNCIAS.Planetas;

public class Planeta extends Astro {

    //atributos
    private Satelite[] satelites;
    private int numSatelites;

    //constructor
    public Planeta(String nombre, double masa, double diametro, double periodoRotacion, double periodoTraslacion, double distanciaMedia, int maxSatelites) {
        super(nombre, masa, diametro, periodoRotacion, periodoTraslacion, distanciaMedia);
        this.satelites = new Satelite[maxSatelites]; //hago la lista (yo decido cuántos satélites como máximo puede tener)
        this.numSatelites = 0; // en principio 0
    }

    //métodos
    public void addSatelite(Satelite s) {
        if (numSatelites < satelites.length) {
            satelites[numSatelites] = s; //Guarda el satélite en la siguiente posición libre del array
            numSatelites++;
        }
    }

    @Override
    public void muestra() {
        System.out.println("--- PLANETA ---");
         // imprime el objeto usando toString()
        System.out.println("Rotación: " + periodoRotacion + " h");
        System.out.println("Traslación: " + periodoTraslacion + " h");
        System.out.println("Distancia media: " + distanciaMedia);

        if (numSatelites > 0) {
            System.out.println("Satélites:");
            for (int i = 0; i < numSatelites; i++) {
                System.out.println(" - " + satelites[i].getNombre());
            }
        }
    }

    //tostring
    @Override
    public String toString() {
        return "Planeta: " + nombre + " | Masa: " + masa + " | Diámetro: " + diametro;
    }
}


