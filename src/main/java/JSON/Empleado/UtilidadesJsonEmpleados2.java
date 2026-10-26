package JSON.Empleado;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

public class UtilidadesJsonEmpleados2 {
    private static final Logger logger = LogManager.getLogger(UtilidadesJsonEmpleados2.class);
    

    public void leeEmpleados(String rutaFichero) {
        try {
            Gson gson = new Gson();
            FileReader fichero = new FileReader(rutaFichero);
            
            Empleado[] empleadosArray = gson.fromJson(fichero, Empleado[].class);
            List<Empleado> empleados = Arrays.asList(empleadosArray);
            
            logger.info("Empleados leídos correctamente: " + empleados);
            
        } catch (Exception e) {
            logger.error("Error al leer empleados: " + e.getMessage(), e);
        }
    }

    public void escribeEmpleado(Empleado empleado, String ruta) {
        Gson gson = new Gson();
        String json = gson.toJson(empleado);
        FileWriter fichero = null;
        
        try {
            fichero = new FileWriter(ruta);
            fichero.write(json);
            logger.info("Empleado escrito con éxito en la ruta: " + ruta);
        } catch (IOException e) {
           logger.error("Error al escribir empleado: " + e.getMessage(), e);
        } finally {
            if (fichero != null) {
                try {
                    fichero.close();
                } catch (IOException e) {
                    logger.error("Error al cerrar el fichero al escribir empleado: " + e.getMessage(), e);
                }
            }
        }
    }
    
    public static void main(String[] args) {
    	
        UtilidadesJsonEmpleados2 utilidades = new UtilidadesJsonEmpleados2();

        logger.info("--- LECTURA DE EMPLEADOS ---");
        utilidades.leeEmpleados("src\\main\\resources\\empleado.json");

        logger.info("--- ESCRITURA DE EMPLEADO ---");
        Empleado nuevoEmpleado = new Empleado("empleado99", "Lucía Gómez", 25, "Tecnologías SL");
        utilidades.escribeEmpleado(nuevoEmpleado, "src\\main\\resources\\nuevo_empleado.json");
    }
}