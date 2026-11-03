package ficheros.EjercicioEstructura.Repositorio;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.google.gson.Gson;
import ficheros.EjercicioEstructura.Modelo.Persona;

public class RepositorioPersonasJson implements IRepositorioPersonas {
	private static final Logger LOGGER = Logger.getLogger(RepositorioPersonasJson.class.getName());
	
    // ATRIBUTOS
    private Gson gson; //ojo 
    private File fichero;
    private List<Persona> personas;

    //CONSTRUCTOR (Carga los datos del JSON al arrancar)
    public RepositorioPersonasJson(File fichero) {
        super();
        this.gson = new Gson();
        this.fichero = fichero;
        this.personas = new ArrayList<>();
        
        try {
            if (fichero.exists()) {
                FileReader lector = new FileReader(fichero);
                Persona[] arrayPersonas = gson.fromJson(lector, Persona[].class);
                lector.close();
                
                if (arrayPersonas != null) {
                    this.personas = new ArrayList<>(Arrays.asList(arrayPersonas));
                }
            }
        } catch (Exception e) {
            LOGGER.severe("Error al leer el fichero JSON: " + e.getMessage());
        }
    }

    // MÉTODOS DE LA INTERFAZ

    @Override
    public List<Persona> findAll() throws RepositorioException {
        return personas;
    }

    @Override
    public Persona findById(String nombre) throws RepositorioException {
        Persona personaEncontrada = null;
        int i = 0;
        
        while (i < personas.size() && personaEncontrada == null) {
            Persona p = personas.get(i);
            if (p.getNombre().equalsIgnoreCase(nombre.trim())) {
                personaEncontrada = p;
            }
            i++;
        }
        
        return personaEncontrada;
    }

    @Override
    public boolean existsById(String nombre) throws RepositorioException {
        boolean existe = false;
        int i = 0;
        
        while (i < personas.size() && !existe) {
            Persona p = personas.get(i);
            if (p.getNombre().equalsIgnoreCase(nombre.trim())) {
                existe = true;
            }
            i++;
        }
        
        return existe;
    }

    @Override
    public int count() throws RepositorioException {
        return personas.size();
    }

    @Override
    public void save(Persona persona) throws RepositorioException {
        int pos = -1;
        int i = 0;
        while (i < personas.size() && pos == -1) {
            if (personas.get(i).getNombre().equalsIgnoreCase(persona.getNombre().trim())) {
                pos = i;
            }
            i++;
        }
        
        // Si no está, la añadimos y si no la actualizamos 
        if (pos == -1) {
            personas.add(persona);
        } else {
            personas.set(pos, persona);
        }
        
        // Guardamos la lista completa en el fichero JSON
        try {
            FileWriter escritor = new FileWriter(fichero);
            gson.toJson(personas, escritor);
            escritor.close();
        } catch (Exception e) {
            LOGGER.severe("Error al guardar en el fichero JSON: " + e.getMessage());
            throw new RepositorioException("Error al guardar en el fichero JSON");
        }
    }

    @Override
    public boolean deleteById(String nombre) throws RepositorioException {
    	
        Persona personaABorrar = findById(nombre);
        boolean borrado = false;
        
        if (personaABorrar != null) {
            personas.remove(personaABorrar); // Gracias al equals, busca por nombre y la elimina
            borrado = true;
            
            // Sobrescribimos el fichero JSON con la lista actualizada
            try {
                FileWriter escritor = new FileWriter(fichero);
                gson.toJson(personas, escritor);
                escritor.close();
            } catch (Exception e) {
                LOGGER.severe("Error al escribir el fichero tras borrar: " + e.getMessage());
                throw new RepositorioException("Error al escribir el fichero tras borrar");
            }
        }
        
        return borrado;
    }
}