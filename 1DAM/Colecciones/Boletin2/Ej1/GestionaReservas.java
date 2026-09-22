package Colecciones.Boletin2.Ej1;

import java.time.LocalDate;
import java.util.*;

public class GestionaReservas {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            RepositorioAnimal repo = new RepositorioAnimal("Doñana", "Huelva", 50000);

            menu(sc, repo);
        }


        // MENÚ PRINCIPAL

        public static void menu(Scanner sc, RepositorioAnimal repo) {

            int opcion;

            do {
                System.out.println("\n--- MENÚ RESERVA ANIMALES ---");
                System.out.println("1. Añadir animal");
                System.out.println("2. Mostrar animales (orden repositorio)");
                System.out.println("3. Mostrar animales ordenados por nombre y fecha nacimiento");
                System.out.println("4. Salir");
                System.out.print("Elige opción: ");

                try {
                    opcion = Integer.parseInt(sc.nextLine()); // Si el usuario no introduce un número, tiro una excepción que lo convierte en -1 y sale del bucle
                } catch (Exception e) {
                    opcion = -1;
                }

                switch (opcion) {

                    case 1:
                        agregarAnimal(sc, repo);
                        break;

                    case 2:
                        repo.mostrarAnimales();
                        break;

                    case 3:
                        mostrarAnimalesOrdenados(repo);
                        List<Animal> animalesLista = repo.treeAList();
                        Collections.sort(animalesLista, new ComparadorNombreFecha());
                        System.out.println(animalesLista);
                        break;

                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                    case 5:
                        mostrarAnimalesPorMedioYNombre(repo);
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }

            } while (opcion != 4);
        }


        // MÉTODO: AGREGAR ANIMAL

        public static void agregarAnimal(Scanner sc, RepositorioAnimal repo) {

            System.out.print("ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Especie: ");
            String especie = sc.nextLine();

            System.out.print("Edad: ");
            int edad = Integer.parseInt(sc.nextLine());

            System.out.print("Clasificación comida (HERVIBORO/CARNIVORO/OMNIVORO): ");
            TipoComida comida = TipoComida.valueOf(sc.nextLine().toUpperCase());

            System.out.print("Fecha nacimiento (AAAA-MM-DD): ");
            LocalDate fecha = LocalDate.parse(sc.nextLine());

            System.out.print("Peso: ");
            double peso = Double.parseDouble(sc.nextLine());

            System.out.print("Medio (AGUA/AIRE/TIERRA): ");
            TipoMedio medio = TipoMedio.valueOf(sc.nextLine().toUpperCase()); //valueof convierte a enum

            System.out.print("Gestación (OVIPARO/OVOVIVIPARO/VIVIPARO): ");
            TipoGestación gestacion = TipoGestación.valueOf(sc.nextLine().toUpperCase());

            Animal a = new Animal(id, nombre, especie, edad, comida, fecha, peso, medio, gestacion); // creo animal

            if (repo.agregarAnimal(a)) {
                System.out.println("Animal añadido correctamente.");
            } else {
                System.out.println("No se pudo añadir (ID duplicado).");
            }
        }


        // MÉTODO: MOSTRAR ORDENADOS POR NOMBRE + FECHA

    public static void mostrarAnimalesOrdenados(RepositorioAnimal repo) {

        TreeSet<Animal> ordenados = new TreeSet<>(new ComparadorNombreFecha());
        ordenados.addAll(repo.getAnimales());

        System.out.println("\n--- ANIMALES ORDENADOS POR NOMBRE Y FECHA DE NACIMIENTO ---");

        for (Animal a : ordenados) {
            System.out.println(a.getNombre() + " | " + a.getFechaNacimiento());
        }
    }
    public static void mostrarAnimalesPorMedioYNombre(RepositorioAnimal repo) {

        TreeSet<Animal> ordenados = new TreeSet<>(new ComparadorMedioNombre());
        ordenados.addAll(repo.getAnimales());

        System.out.println("\n--- ANIMALES ORDENADOS POR MEDIO Y NOMBRE ---");

        for (Animal a : ordenados) {
            System.out.println(a.getMedio() + " | " + a.getNombre());
        }
    }

}

