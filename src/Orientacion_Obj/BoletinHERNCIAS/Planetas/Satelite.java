package Orientacion_Obj.BoletinHERNCIAS.Planetas;

public class Satelite extends Astro {

    private Planeta planeta;

    public Satelite(String nombre, double masa, double diametro,
                    double periodoRotacion, double periodoTraslacion,
                    double distanciaMedia, Planeta planeta) {

        super(nombre, masa, diametro, periodoRotacion, periodoTraslacion, distanciaMedia);
        this.planeta = planeta;
    }

    @Override
    public void muestra() {
        System.out.println("=== SATÉLITE ===");
        System.out.println(this);
        System.out.println("Orbita a: " + planeta.getNombre());
        System.out.println("Rotación: " + periodoRotacion + " h");
        System.out.println("Traslación: " + periodoTraslacion + " h");
        System.out.println("Distancia media: " + distanciaMedia);
    }

    @Override
    public String toString() {
        return "Satélite: " + nombre + " | Masa: " + masa + " | Diámetro: " + diametro;
    }
}

