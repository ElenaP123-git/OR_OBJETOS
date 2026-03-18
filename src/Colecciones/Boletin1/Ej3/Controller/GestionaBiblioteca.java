package Colecciones.Boletin1.Ej3.Controller;

import Colecciones.Boletin1.Ej3.Exceptions.BibliotecaException;
import Colecciones.Boletin1.Ej3.Models.Biblioteca;
import Colecciones.Boletin1.Ej3.Models.Libro;

import java.util.Scanner;

public class GestionaBiblioteca {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Biblioteca b = new Biblioteca();

        menu(sc, b);
    }

    public static void menu(Scanner sc, Biblioteca b) {

        int opcion = 0;

        do {
            System.out.println("\n--- MENÚ BIBLIOTECA ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Prestar libro");
            System.out.println("3. Devolver libro");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Mostrar información de un libro");
            System.out.println("6. Buscar por título");
            System.out.println("7. Buscar por autor");
            System.out.println("8. Salir");

            System.out.print("Elige opción: ");
            try {
                opcion = Integer.parseInt(sc.nextLine()); //si el user no introduce un número, tiro excepción
            } catch (Exception e) {
                System.out.println("Opción inválida.");
                opcion = -1;
            }

            switch (opcion) {

                case 1:
                    System.out.print("Título: ");
                    String t = sc.nextLine();
                    System.out.print("Autor: ");
                    String a = sc.nextLine();
                    System.out.print("Género: ");
                    String g = sc.nextLine();
                    System.out.print("Año: ");
                    int anio = Integer.parseInt(sc.nextLine());
                    System.out.print("Ejemplares: ");
                    int ej = Integer.parseInt(sc.nextLine());

                    b.agregarLibro(new Libro(t, a, g, anio, ej));
                    break;

                case 2:
                    try {
                        System.out.print("Título: ");
                        b.prestarLibro(sc.nextLine());
                    } catch (BibliotecaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.print("Título: ");
                        b.devolverLibro(sc.nextLine());
                    } catch (BibliotecaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    b.mostrarInventario();
                    break;

                case 5:
                    try {
                        System.out.print("Título: ");
                        b.mostrarInfo(sc.nextLine());
                    } catch (BibliotecaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.out.print("Título: ");
                    Libro l1 = b.buscarPorTitulo(sc.nextLine());

                    break;

                case 7:
                    System.out.print("Autor: ");
                    Libro l2 = b.buscarPorAutor(sc.nextLine());

                    break;

                case 8:
                    System.out.println("Saliendo...");
                    break;

                case 9:
                    System.out.print("Título del libro: ");
                    String tPrestamo = sc.nextLine();
                    System.out.print("DNI del usuario: ");
                    String dni = sc.nextLine();
                    b.prestarLibro(tPrestamo, dni);
                    break;

                case 10:
                    System.out.print("Título del libro: ");
                    String tDevolver = sc.nextLine();
                    b.devolverLibro(tDevolver);
                    break;

                case 11:
                    b.getRepoP().mostrarHistorial();
                    break;

                case 12:
                    System.out.print("Título del libro: ");
                    String tBuscar = sc.nextLine();
                    System.out.print("Autor del libro: ");
                    String aBuscar = sc.nextLine();
                    b.getRepoP().buscarPrestamosLibro(tBuscar, aBuscar);
                    break;


                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 8);
    }
}
