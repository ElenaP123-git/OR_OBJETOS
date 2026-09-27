package APUNTES_POO.BoletinHERNCIAS.VideojuegosInsrtof;

public class Mago extends Personaje {

    public Mago(String nombre) {
        super(nombre);
    }

    public void lanzarHechizo() {
        System.out.println(nombre + " lanza un HECHIZO");
    }
}

