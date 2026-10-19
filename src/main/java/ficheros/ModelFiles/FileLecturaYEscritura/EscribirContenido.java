package ficheros.ModelFiles.FileLecturaYEscritura;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EscribirContenido {
    private static final Logger LOGGER = Logger.getLogger(EscribirContenido.class.getName());

    public static void main(String[] args) {
        String ruta = "fichero_salida.txt";
        
        //Lo que quiero mostrar
        List<Double> notasPepe = new ArrayList<Double>();
        notasPepe.add(1.0);
        notasPepe.add(3.5);
        notasPepe.add(7.7);
        Persona pepe = new Persona("Pepe", notasPepe);

        List<Double> notasMarcos = new ArrayList<Double>();
        notasMarcos.add(2.0);
        Persona marcos = new Persona("Marcos", notasMarcos);

        List<Persona> personas = new ArrayList<Persona>();
        personas.add(pepe);
        personas.add(marcos);

        // Escribimos la lista en el fichero
        escribirPersonasEnFichero(ruta, personas);
    }

    public static void escribirPersonasEnFichero(String rutaYNombre, List<Persona> listaPersonas) {
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            // El segundo parámetro indica:
            // false -> sobrescribe el fichero desde cero
            // true  -> añade el contenido al final del fichero existente
            fw = new FileWriter(rutaYNombre, false);
            pw = new PrintWriter(fw);

            // Escribimos una primera línea de cabecera (opcional)
            pw.println("Nombre Notas");

            // Recorremos la lista de personas y escribimos sus datos
            for (int i = 0; i < listaPersonas.size(); i++) {
                Persona p = listaPersonas.get(i);
                
                // Escribimos el nombre sin salto de línea
                pw.print(p.getNombre());

                // Escribimos cada nota separada por un espacio
                List<Double> notas = p.getListaNotas();
                for (int j = 0; j < notas.size(); j++) {
                    pw.print(" " + notas.get(j));
                }

                // Al terminar las notas del alumno, damos un salto de línea
                pw.println();
            }

            LOGGER.info("Fichero escrito correctamente en: " + rutaYNombre);

        } catch (IOException e) {
            LOGGER.severe("Error al escribir en el fichero: " + e.getMessage());
        } finally {
            // Es muy importante cerrar el PrintWriter para asegurar que todos los datos en memoria se guarden físicamente en el disco.
          
            if (pw != null) {
                pw.close();
            }
        }
    }
}