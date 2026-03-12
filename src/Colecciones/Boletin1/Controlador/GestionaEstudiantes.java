package Colecciones.Boletin1.Controlador;

import Colecciones.Boletin1.Exceptions.GrupoNoEncontradoException;
import Colecciones.Boletin1.Modelo.Estudiante;
import Colecciones.Boletin1.Modelo.Grupo;
import Colecciones.Boletin1.Modelo.Instituto;

import java.util.Scanner;

public class GestionaEstudiantes {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        Instituto inst = new Instituto();
        int opcion = 0;

        do {

            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Agregar estudiante a un grupo");
            System.out.println("2. Agregar grupo al instituto");
            System.out.println("3. Mostrar estudiantes con notas por grupo");
            System.out.println("4. Mostrar info básica de un grupo");
            System.out.println("5. Promedio de notas de un estudiante");
            System.out.println("6. Promedio de notas de un grupo");
            System.out.println("7. Salir");

            // VALIDACIÓN DE OPCIÓN

                switch (opcion) {

                    case 1:
                        System.out.print("Grupo: ");
                        Grupo g = inst.buscarGrupo(sc.nextLine()); // DONDE PONGO EL TRY Y CATCH DE ESTO???? HELP

                        System.out.print("Nombre estudiante: ");
                        String nombre = sc.nextLine();

                        System.out.print("ID estudiante: ");
                        String id = sc.nextLine();

                        g.agregarEstudiante(new Estudiante(nombre, id)); // hay que pasarle un estudiante, o lo creas antes o lo creas ahora, sick
                        System.out.println("Estudiante agregado.");
                        break;

                    case 2:
                        System.out.print("Descripción del grupo: ");
                        String desc = sc.nextLine();

                        System.out.print("Tutor: ");
                        String tutor = sc.nextLine();

                        System.out.print("Aula: ");
                        String aula = sc.nextLine();

                        inst.agregarGrupo(new Grupo(desc, tutor, aula));
                        System.out.println("Grupo agregado.");
                        break;

                    case 3:
                        System.out.print("Grupo: ");
                        Grupo g3 = inst.buscarGrupo(sc.nextLine());
                        for (Estudiante est : g3.getEstudiantes()) {
                            System.out.println(est);
                        }
                        break;

                    case 4:
                        System.out.print("Grupo: ");
                        Grupo g4 = inst.buscarGrupo(sc.nextLine());
                        System.out.println(g4);
                        break;

                    case 5:
                        System.out.print("Grupo: ");
                        Grupo g5 = inst.buscarGrupo(sc.nextLine());

                        System.out.print("ID estudiante: ");
                        Estudiante est = g5.buscarEstudiante(sc.nextLine());

                        System.out.println("Media: " + est.calcularPromedio());
                        break;

                    case 6:
                        System.out.print("Grupo: ");
                        Grupo g6 = inst.buscarGrupo(sc.nextLine());
                        System.out.println("Media del grupo: " + g6.promedioGrupo());
                        break;

                    case 7:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }

        } while (opcion != 7);

    }
}


