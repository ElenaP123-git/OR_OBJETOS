package Colecciones.Clase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GestionaListas {
    public static void main(String[] args) {

        //ARRAYLIST
        List <String> listaArray = new ArrayList <String>();
        listaArray.add("Barcelona");
        listaArray.add("Huelva");
        listaArray.add("Madrid");
        System.out.println(listaArray.contains("Madrid")); // me dice si tiene madrid (true)
        System.out.println(listaArray.contains("Sevilla")); //false

        System.out.println("\n");
        for (String l: listaArray){ //los arraylist son los mejores corredores (recorrer) y son malos inserctores (si añades entre medio más cosas, va mal, ns)
            System.out.println(l);
        }

        System.out.println("\n");
        for (int i = 0; i < listaArray.size(); i++){ // size es como lenght
            System.out.println(listaArray.get(i)); // si solo pones i, se imprime 0,1,2...
        }

        System.out.println("\n");
        Iterator <String> iterator = listaArray.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


        //LINKEDLIST
        List<String> listaLinked = new LinkedList<String>(); //mala para recorrido y buena para inserciones en medio
        listaLinked.add("Sevilla");
        listaLinked.add("Córdoba");
        listaLinked.add("Málaga");


    }
}
