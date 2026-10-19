package ficheros.ModelFiles.FileLecturaYEscritura;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Logger;

public class MostrarContenido {
    private static final Logger LOGGER = Logger.getLogger(MostrarContenido.class.getName());
    
    public static void main(String[] args) {
        MostrarContenido lector = new MostrarContenido();
        
        String ruta = "fichero1.txt";
        
        List<Persona> personas = new ArrayList<Persona>();
        
        try {
            FileReader fr = new FileReader(ruta);
            Scanner sc = new Scanner(fr);
            //sc.useDelimiter(","); por si quiero separar por comas
            sc.useLocale(Locale.ENGLISH); // para que los decimales usen el punto (.)
        
            if (sc.hasNextLine()) { //se descarta la primera línea
                sc.nextLine(); 
            }
            
            while (sc.hasNext()) {
                String nombre = sc.next();
                List<Double> notas = new ArrayList<Double>();
                
                while (sc.hasNextDouble()) {
                    notas.add(sc.nextDouble());
                }
                
                // Faltaba añadir la persona creada a la lista
                Persona p = new Persona(nombre, notas);
                personas.add(p);
            }
            
            // Cerramos el scanner y el reader 
            sc.close();
            fr.close();

            for (int i = 0; i < personas.size(); i++) {
                Persona persona = personas.get(i);
                LOGGER.info("Procesado alumno: " + persona.getNombre());
            }
            
        } catch (FileNotFoundException e) {
            LOGGER.severe("No se pudo encontrar el fichero: " + e.getMessage());
        } catch (Exception e) {
            LOGGER.severe("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
}