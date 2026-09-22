package Colecciones.Boletin2.Ej2;

import Colecciones.Boletin2.Ej1.ComparadorNombreFecha;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class GestionaHistorial {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Historial historial = new Historial();

        try {
            historial.agregarPagina("google.com", LocalDateTime.of(2023, 1, 10, 10, 30));
            historial.agregarPagina("google.com", LocalDateTime.now());
            historial.agregarPagina("youtube.com", LocalDateTime.of(2022, 5, 3, 18, 15));
            historial.agregarPagina("youtube.com", LocalDateTime.now());
            historial.agregarPagina("google.com", LocalDateTime.now().plusDays(1)); // FUTURA → excepción
        } catch (HistorialException e) {
            System.out.println("EXCEPCIÓN CAPTURADA: " + e.getMessage());
        }

        menu(sc, historial);
    }

    public static void menu(Scanner sc, Historial historial) {

        int opcion;

        do {
            System.out.println("\n--- MENÚ HISTORIAL ---");
            System.out.println("1. Agregar página");
            System.out.println("2. Mostrar historial completo");
            System.out.println("3. Mostrar historial de un día");
            System.out.println("4. Mostrar registros por URL");
            System.out.println("5. Borrar visitas a una URL");
            System.out.println("6. Mostrar historial ordenado por URL");
            System.out.println("7. Salir");
            System.out.print("Opción: ");

            opcion = Integer.parseInt(sc.nextLine()); //se puede poner try y catch

            switch (opcion) {

                case 1:
                    agregarPagina(sc, historial);
                    break;

                case 2:
                    mostrarHistorialCompleto(historial);
                    break;

                case 3:
                    mostrarPorDia(sc, historial);
                    break;

                case 4:
                    mostrarPorUrl(sc, historial);
                    break;

                case 5:
                    borrarPorUrl(sc, historial);
                    break;

                case 6:
                    mostrarOrdenadoPorUrl(historial);
                    break;

                case 7:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }


        } while (opcion != 7);
    }


    private static void agregarPagina(Scanner sc, Historial historial) {
        try {
            System.out.print("URL: ");
            String url = sc.nextLine();

            System.out.print("Fecha (AAAA-MM-DDTHH:MM) o vacío para ahora: ");
            String entrada = sc.nextLine();

            LocalDateTime fecha;

            if (entrada.equals("")) {
                fecha = LocalDateTime.now();
            } else {
                fecha = LocalDateTime.parse(entrada);
            }

            historial.agregarPagina(url, fecha);

        } catch (HistorialException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static void mostrarPorDia(Scanner sc, Historial historial) {

        System.out.print("Introduce fecha (AAAA-MM-DD): ");
        LocalDate dia = LocalDate.parse(sc.nextLine());

        System.out.println("\n--- HISTORIAL DEL DÍA " + dia + " ---");

        boolean encontrado = false;

        for (PaginaWeb p : historial.getPaginas()) {
            if (p.getFecha().toLocalDate().equals(dia)) {
                System.out.println(p);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay registros para ese día.");
        }
    }


    private static void mostrarPorUrl(Scanner sc, Historial historial) {

        System.out.print("Introduce URL: ");
        String url = sc.nextLine();

        System.out.println("\n--- HISTORIAL PARA " + url + " ---");

        boolean encontrado = false;

        for (PaginaWeb p : historial.getPaginas()) {
            if (p.getUrl().equalsIgnoreCase(url)) {
                System.out.println(p);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay registros para esa URL.");
        }
    }


    private static void borrarPorUrl(Scanner sc, Historial historial) {
        System.out.print("Introduce URL a borrar: ");
        String url = sc.nextLine();

        historial.borrarPorUrl(url);
        System.out.println("Visitas eliminadas.");
    }

    private static void mostrarOrdenadoPorUrl(Historial historial) {
        List<PaginaWeb> lista = historial.treeAList();
        Collections.sort(lista,new ComparadorUrl());
        System.out.println(lista);
    }


    private static void mostrarHistorialCompleto(Historial historial) {

        System.out.println("\n--- HISTORIAL COMPLETO ---");

        for (PaginaWeb p : historial.getPaginas()) {
            System.out.println(p);
        }
    }

}

