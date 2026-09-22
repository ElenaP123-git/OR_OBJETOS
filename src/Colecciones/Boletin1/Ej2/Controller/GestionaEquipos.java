package Colecciones.Boletin1.Ej2.Controller;

import Colecciones.Boletin1.Ej2.Exceptions.DeportivosException;
import Colecciones.Boletin1.Ej2.Model.Alumno;
import Colecciones.Boletin1.Ej2.Model.Equipo;

import java.util.zip.DataFormatException;

public class GestionaEquipos {

            public static void main(String[] args) {

                try {
                    // Crear alumnos
                    Alumno a1 = new Alumno("Ana", "111A");
                    Alumno a2 = new Alumno("Luis", "222B");
                    Alumno a3 = new Alumno("Marta", "333C");
                    Alumno a4 = new Alumno("Pepe", "444D");

                    // Crear equipos
                    Equipo futbol = new Equipo("Fútbol");
                    Equipo baloncesto = new Equipo("Baloncesto");

                    // Añadir alumnos
                    futbol.addAlumno(a1);
                    futbol.addAlumno(a2);
                    futbol.addAlumno(a3);

                    baloncesto.addAlumno(a2);
                    baloncesto.addAlumno(a4);

                    // Mostrar equipos
                    futbol.mostrarEquipo();
                    baloncesto.mostrarEquipo();

                    // Unión
                    Equipo union = futbol.union(baloncesto);
                    System.out.println("\nUNIÓN:");
                    union.mostrarEquipo();

                    // Intersección
                    Equipo inter = futbol.interseccion(baloncesto);
                    System.out.println("\nINTERSECCIÓN:");
                    inter.mostrarEquipo();

                    // Borrar alumno
                    futbol.removeAlumno(a3);
                    System.out.println("\nFútbol tras borrar a Marta:");
                    futbol.mostrarEquipo();

                } catch (DeportivosException e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
            }
        }

