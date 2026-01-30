package Orientacion_Obj.Clase.Personas;

public class Persona {
    // atributos

    int edad;
    String nombre;
    String lugar_nacimiento;
    String deporte_fav;
    String peli_fav;
    String juego_fav;

    //constructores

    public Persona(int edad, String nombre, String lugar_nacimiento, String deporte_fav, String peli_fav, String juego_fav) {
        this.edad = edad;
        this.nombre = nombre;
        this.lugar_nacimiento = lugar_nacimiento;
        this.deporte_fav = deporte_fav;
        this.peli_fav = peli_fav;
        this.juego_fav = juego_fav;
    }

    // constructor por defecto

    public Persona() { // constructor por defecto (sin parámetros)
        this.edad = 0;
        this.nombre = "";
        this.lugar_nacimiento  = "";
        this.deporte_fav = "";
        this.peli_fav = "";
        this.juego_fav = "";
    }

    //métodos

    void hablar(){
        System.out.println("Hablando: " + nombre);
    }
    boolean ha_robado(){
        return false;
    }
    void comer(){
        System.out.println("Comiendo: " + nombre);
    }

    @Override           // "el tipo persona, me lo pasa a String para que java pueda imprimirlo"
    public String toString() {
        return "Persona{" +
                "edad=" + edad +
                ", nombre='" + nombre + '\'' +
                ", lugar_nacimiento='" + lugar_nacimiento + '\'' +
                ", deporte_fav='" + deporte_fav + '\'' +
                ", peli_fav='" + peli_fav + '\'' +
                ", juego_fav='" + juego_fav + '\'' +
                '}';
    }
}
class Animal{                    // puedo crear más clases pero no public

}
