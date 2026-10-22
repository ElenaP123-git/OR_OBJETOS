package ficheros.EjercicioEstructura.Repositorio;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Logger;
import java.io.FileNotFoundException;

import ficheros.EjercicioEstructura.Modelo.Persona;
import ficheros.ModelFiles.BoletinFile10;

public class RepositorioPersonasTxt implements IRepositorioPersonas {
	//LOGGER
	private static final Logger LOGGER = Logger.getLogger(RepositorioPersonasTxt.class.getName());
    
	//ATRIBUTOS
    private File fichero;
    private List<Persona> personas;
    
    //CONSTRUCTOR
    public RepositorioPersonasTxt(File fichero) {
        super();
        this.fichero = fichero;
        this.personas = new ArrayList<>(); 
    }

    //MÉTODOS
    
    private List<Persona> leerFicheroCargaPersona(String rutaYNombre) throws FileNotFoundException {
        Scanner sc = null;
        List<Persona> personasDevueltas = new ArrayList<Persona>(); // Lista que almacenará las personas leídas
        
        try {
            // Abre el fichero
            FileReader fichero = new FileReader(rutaYNombre);
            sc = new Scanner(fichero);
            sc.useLocale(Locale.ENGLISH);
            
            // Lee el fichero
            while (sc.hasNext()) {
                String nombrePersona = sc.next();
                
                // Lista de notas para esta persona concreta
                List<Double> notas = new ArrayList<Double>();
               
                while (sc.hasNextDouble()) {
                    notas.add(sc.nextDouble());
                }
                
                // Creamos la persona con su nombre y su lista de notas y lo guardamos
                Persona p = new Persona(nombrePersona, notas);
                personasDevueltas.add(p);
            }
            
        }catch(FileNotFoundException e)
        {
        	LOGGER.severe(e.getMessage());
        	throw e; //para que llegue el aviso al método
        }
        finally {
            if (sc != null) {
                sc.close();
            }
        }
        
        return personasDevueltas;
    }
    
    //Miro si la lista está llena y si no, leo el fichero
    
    @Override
    public List<Persona> findAll() throws RepositorioException {
        // Si la lista está vacía, leemos del fichero
        if (personas == null || personas.isEmpty()) {
            try {
                personas = leerFicheroCargaPersona(fichero.getAbsolutePath());
            } catch (FileNotFoundException e) {
                throw new RepositorioException("No se ha encontrado el fichero: " + e.getMessage());
            } catch (Exception e) {
                throw new RepositorioException("Error al cargar los datos: " + e.getMessage());
            }
        }
        
        return personas;
    }
    
    @Override
    public Persona findById(String nombre) throws RepositorioException {
        findAll(); // Asegura que la lista está llena
        
        Persona personaEncontrada = null;
        
        if (personas != null && nombre != null) {
            for (int i = 0; i < personas.size(); i++) {
                Persona p = personas.get(i);
                
                if (p.getNombre().equalsIgnoreCase(nombre.trim()) && personaEncontrada == null) {
                    personaEncontrada = p;
                }
            }
        }
        
        return personaEncontrada; 
    }

	@Override
	public void save(Persona persona) throws RepositorioException {
		
		
	}
    
    
}