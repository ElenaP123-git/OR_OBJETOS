package ej4.Controller;

import java.time.LocalDate;
import java.util.List;

import ej4.Exceptions.EldenException;
import ej4.Model.Encuentro;
import ej4.Model.SinLuz;
import ej4.Repository.RegistroSinLuz;

public class GestionaEncuentrosSinLuz {

    public static void main(String[] args) {
        RegistroSinLuz registro = new RegistroSinLuz();

        // 3 SinLuz 
        SinLuz ardyn = new SinLuz("Ardyn");
        SinLuz selene = new SinLuz("Selene");
        SinLuz kael = new SinLuz("Kael");

        registro.agregaSinLuz(ardyn);
        registro.agregaSinLuz(selene);
        registro.agregaSinLuz(kael);

        // 7 encuentros
        Encuentro e1 = new Encuentro("Asalto al Bastión Carmesí", LocalDate.of(2025, 3, 10), 8, List.of("Caballero Carmesí", "Tirano de Ceniza"));
        Encuentro e2 = new Encuentro("Emboscada en el Bosque Umbrío", LocalDate.of(2025, 3, 14), 5, List.of("Lobo Siniestro", "Bandido espectral"));
        Encuentro e3 = new Encuentro("Duelo en la Cripta Helada", LocalDate.of(2025, 3, 18), 7, List.of("Espectro del Hielo", "Mago congelado"));
        Encuentro e4 = new Encuentro("Resistencia en la Torre Abandonada", LocalDate.of(2025, 3, 20), 6, List.of("Arquero maldito", "Guardián de piedra"));
        Encuentro e5 = new Encuentro("Invasión en la Villa Marchita", LocalDate.of(2025, 3, 23), 9, List.of("Gigante marchito", "Portador del Plomo"));
        Encuentro e6 = new Encuentro("Caza en el Lago Sombrío", LocalDate.of(2025, 3, 25), 4, List.of("Serpiente negra", "Sombra anfibia"));
        Encuentro e7 = new Encuentro("Asalto final al Nexo del Caos", LocalDate.of(2025, 3, 30), 10, List.of("Señor del Caos", "Centinela oscuro", "Eco ardiente"));

        // Invocar a agregaEncuentro
        System.out.println("=== 1. AÑADIENDO ENCUENTROS Y MOSTRANDO PERSONAJES (ORDENADOS ALFABÉTICAMENTE) ===");
        try {
            registro.agregaEncuentro(ardyn.getIdentificador(), e1);
            registro.agregaEncuentro(ardyn.getIdentificador(), e2);

            registro.agregaEncuentro(selene.getIdentificador(), e3);
            registro.agregaEncuentro(selene.getIdentificador(), e4);

            registro.agregaEncuentro(kael.getIdentificador(), e5);
            registro.agregaEncuentro(kael.getIdentificador(), e6);

            for (SinLuz s : registro.getRegistro()) {
                System.out.println(s);
            }
        } catch (EldenException e) {
            System.err.println("Error no esperado: " + e.getMessage());
        }

        // Agregar a un SinLuz no almacenado 
        System.out.println("\n=== 2. PRUEBA DE EXCEPCIÓN CON ID INEXISTENTE ===");
        try {
            registro.agregaEncuentro(99, e7); // El ID 99 no existe
        } catch (EldenException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }

        // Modificar un encuentro existente 
        System.out.println("\n=== 3. COMPROBANDO ACTUALIZACIÓN DE UN ENCUENTRO ===");
        try {
            SinLuz pArdyn = registro.getSinLuz(ardyn.getIdentificador());
            System.out.println("ANTES de actualizar: " + pArdyn);

           Encuentro e1Modificado = new Encuentro("Asalto al Bastión Carmesí", LocalDate.of(2025, 3, 10), 10, List.of("Caballero Carmesí Élite", "Tirano de Ceniza"));
            registro.agregaEncuentro(ardyn.getIdentificador(), e1Modificado);

            System.out.println("\nDESPUÉS de actualizar: " + pArdyn);
        } catch (EldenException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Filtrado por dificultad > 6
        System.out.println("\n=== 5. SINLUZ CON ENCUENTROS DE DIFICULTAD MAYOR QUE 6 ===");
        List<SinLuz> filtrados = registro.getSinLuzConDificultadMayorQue(6);
        for (SinLuz s : filtrados) {
            System.out.println("- " + s.getNombre() + " (ID: " + s.getIdentificador() + ")");
        }
    }
}