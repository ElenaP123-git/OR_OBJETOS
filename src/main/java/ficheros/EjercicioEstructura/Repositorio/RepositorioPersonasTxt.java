package ficheros.EjercicioEstructura.Repositorio;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Logger;
import java.io.FileNotFoundException;

import ficheros.EjercicioEstructura.Modelo.Persona;

public class RepositorioPersonasTxt implements IRepositorioPersonas {
	// LOGGER
	private static final Logger LOGGER = Logger.getLogger(RepositorioPersonasTxt.class.getName());
    
	// ATRIBUTOS
    private File fichero;
    private List<Persona> personas;
    
    // CONSTRUCTOR
    public RepositorioPersonasTxt(File fichero) {
        super();
        this.fichero = fichero;
        this.personas = new ArrayList<>(); 
    }

    // MÉTODOS 
    
    public List<Persona> leerFicheroCargaPersona(String rutaYNombre) throws FileNotFoundException {
        Scanner sc = null;
        List<Persona> personasDevueltas = new ArrayList<Persona>();
        
        try {
            FileReader lectorFichero = new FileReader(rutaYNombre);
            sc = new Scanner(lectorFichero);
            sc.useLocale(Locale.ENGLISH);
            
            while (sc.hasNext()) {
                String nombrePersona = sc.next();
                List<Double> notas = new ArrayList<Double>();
               
                while (sc.hasNextDouble()) {
                    notas.add(sc.nextDouble());
                }
                
                Persona p = new Persona(nombrePersona, notas);
                personasDevueltas.add(p);
            }
            
        } catch(FileNotFoundException e) {
        	LOGGER.severe(e.getMessage());
        	throw e; 
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        
        return personasDevueltas;
    }

    // Método para volcar la lista actualizada al fichero de texto
    public void escribirFicheroDesdeLista(List<Persona> listaAEscribir) throws RepositorioException {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(fichero);
            
            int i = 0;
            while (i < listaAEscribir.size()) {
                Persona p = listaAEscribir.get(i);
                
                pw.print(p.getNombre());
                
                List<Double> notas = p.getNotas();
                if (notas != null) {
                    int j = 0;
                    while (j < notas.size()) {
                        pw.print(" " + notas.get(j));
                        j++;
                    }
                }
                pw.println();
                i++;
            }
        } catch (Exception e) {
            LOGGER.severe("Error al escribir en el fichero: " + e.getMessage());
            throw new RepositorioException("Error al escribir en el fichero: " + e.getMessage());
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    // Método para buscar la posición de una persona
    public int buscarPosicion(List<Persona> lista, String nombre) {
        int pos = -1;
        int i = 0;
        while (i < lista.size() && pos == -1) {
            Persona p = lista.get(i);
            if (p.getNombre().equalsIgnoreCase(nombre.trim())) {
                pos = i; 
            }
            i++;
        }
        return pos;
    }
    
    // MÉTODOS DE LA INTERFAZ
    
    @Override
    public List<Persona> findAll() throws RepositorioException {
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
        findAll(); 
        
        Persona personaEncontrada = null;
        
        if (personas != null && nombre != null) {
            int i = 0;
            while (i < personas.size() && personaEncontrada == null) {
                Persona p = personas.get(i);
                
                if (p.getNombre().equalsIgnoreCase(nombre.trim())) {
                    personaEncontrada = p;
                }
                i++;
            }
        }
        
        return personaEncontrada; 
    }

    @Override
    public boolean existsById(String nombre) throws RepositorioException {
        findAll();
        int pos = buscarPosicion(personas, nombre);
        return pos != -1;
    }

    @Override
    public int count() throws RepositorioException {
        findAll();
        return personas.size();
    }

	@Override
	public void save(Persona persona) throws RepositorioException {
		if (persona != null) {
		    findAll();
		    
		    // Copia de seguridad 
		    List<Persona> copiaLista = new ArrayList<>(personas);
		    
		    int pos = buscarPosicion(copiaLista, persona.getNombre());
		    
		    if (pos == -1) {
		        copiaLista.add(persona); // Alta si no existe
		    } else {
		        copiaLista.set(pos, persona); // Modificación si ya existe
		    }
		    
		    escribirFicheroDesdeLista(copiaLista);
		    
		    // Si la escritura va bien, actualizamos la lista oficial
		    this.personas = copiaLista;
		}
	}

    @Override
    public boolean deleteById(String nombre) throws RepositorioException {
        findAll();
        
        List<Persona> copiaLista = new ArrayList<>(personas);
        int pos = buscarPosicion(copiaLista, nombre);
        boolean borrado = false;
        
        if (pos != -1) {
            copiaLista.remove(pos);
            escribirFicheroDesdeLista(copiaLista); // Actualizar el fichero
            this.personas = copiaLista;
            borrado = true;
        }
        
        return borrado;
    }
}