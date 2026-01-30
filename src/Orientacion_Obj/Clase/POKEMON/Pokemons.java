package Orientacion_Obj.Clase.POKEMON;

import java.util.Arrays;

public class Pokemons {

    int nivel;
    int vida;
    String nombre;
    String tipo;
    Pokemons [] evoluciones ;

    public Pokemons (Pokemons [] evoluciones, String nombre, int nivel, int vida, String tipo){
        this.nivel = nivel;
        this.vida = vida;
        this.nombre = nombre;
        this.tipo = tipo;
        this.evoluciones = evoluciones;
    }

    public Pokemons() {
        this.nivel = 0;
        this.vida = 0;
        this.nombre = "";
        this.tipo = "";
        this.evoluciones = new Pokemons[2] ;
    }
    boolean luchar(Pokemons enemigo){ // enemigo tipo pokemon
        System.out.println("COMIENZA LA BATALLA!!!");
        // gana el que tenga más vida
        if (this.vida > enemigo.vida) {
            return true;
        }
        else {
            return false;
        }
    }
    void evolucionar(){
        System.out.println("POKEMON EVOLUCIÓN!!!");
        if (evoluciones != null && evoluciones.length > 0 && evoluciones[0] != null) {
            Pokemons evo = evoluciones[0];
            this.nombre = evo.nombre;
            this.tipo = evo.tipo;
            this.nivel = evo.nivel;
            this.vida = evo.vida;

            System.out.println("¡" + nombre + " ha evolucionado!");
        }
        else {
            System.out.println("Este Pokémon no tiene evoluciones.");
        }
    }

    @Override
    public String toString() {
        return "Pokemons{" +
                "nivel=" + nivel +
                ", vida=" + vida +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", evoluciones=" + Arrays.toString(evoluciones) +
                '}';
    }
}
