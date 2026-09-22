package Orientacion_Obj.Clase.POKEMON;

public class GestionPokemon {
    public static void main(String[] args) {

        // creo a Pikachu
        Pokemons pikachu = new Pokemons(null, "Pikachu", 20, 80, "rayo");
        Pokemons[] evolucionesCharmander = { pikachu };

        // creo a Charmander
        Pokemons charmander = new Pokemons(null, "Charmander", 10, 50,"Fuego");

        // creo a squirtle
        Pokemons squirtle = new Pokemons( null, "Squirtle", 12, 60, "Agua" );

        // Mostramos información
        System.out.println(charmander);
        System.out.println(squirtle);
        // Lucha
        boolean resultado = charmander.luchar(squirtle);
        System.out.println("¿Charmander ganó? " + resultado);
        // Evolución
        charmander.evolucionar();
        System.out.println(charmander);
    }
}
