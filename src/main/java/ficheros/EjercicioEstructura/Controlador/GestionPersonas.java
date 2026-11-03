package ficheros.EjercicioEstructura.Controlador;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import ficheros.EjercicioEstructura.Modelo.Persona;
import ficheros.EjercicioEstructura.Servicio.IServicioPersonas;
import ficheros.EjercicioEstructura.Servicio.ServicioPersonas;

public class GestionPersonas {
    
    // ATRIBUTOS (Ruta del fichero de datos)
    private static final String RUTA_DATOS = "src/main/resources/personas.txt";

    public static void main(String[] args) {
        
        // Crear el objeto File y el Servicio
        File fichero = new File(RUTA_DATOS);
        IServicioPersonas servicio = new ServicioPersonas(fichero); 

        System.out.println("--- PROBANDO ALTAS ---");
        List<Double> notasPepe = Arrays.asList(6.0, 7.5, 8.0);
        boolean altaPepe = servicio.alta("Pepe", notasPepe);
        System.out.println("¿Alta de Pepe?: " + altaPepe);

        List<Double> notasMaria = Arrays.asList(9.0, 10.0);
        boolean altaMaria = servicio.alta("Maria", notasMaria);
        System.out.println("¿Alta de Maria?: " + altaMaria);


        System.out.println("\n--- LISTANDO PERSONAS Y SUS MEDIAS ---");
        List<Persona> listaPersonas = servicio.listar();
        
        int i = 0;
        while (i < listaPersonas.size()) {
            Persona p = listaPersonas.get(i);
            double media = servicio.media(p);
            System.out.println("Alumno: " + p.getNombre() + " | Notas: " + p.getNotas() + " | Media: " + media);
            i++;
        }


        System.out.println("\n--- BUSCANDO A UNA PERSONA ---");
        Persona encontrada = servicio.buscar("Pepe");
        if (encontrada != null) {
            System.out.println("Persona encontrada con éxito: " + encontrada);
        }


        System.out.println("\n--- MODIFICANDO NOTAS ---");
        List<Double> nuevasNotas = Arrays.asList(4.0, 5.0);
        boolean modificado = servicio.modificarNotas("Pepe", nuevasNotas);
        System.out.println("¿Notas modificadas para Pepe?: " + modificado);


        System.out.println("\n--- BORRANDO A UNA PERSONA (BAJA) --");
        boolean borrado = servicio.baja("Maria");
        System.out.println("¿Baja de Maria realizada?: " + borrado);


        System.out.println("\n--- LISTADO FINAL TRAS LOS CAMBIOS ---");
        List<Persona> listaFinal = servicio.listar();
        
        int j = 0;
        while (j < listaFinal.size()) {
            System.out.println(listaFinal.get(j));
            j++;
        }
    }
}