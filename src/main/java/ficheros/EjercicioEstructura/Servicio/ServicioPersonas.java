package ficheros.EjercicioEstructura.Servicio;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import ficheros.EjercicioEstructura.Modelo.Persona;
import ficheros.EjercicioEstructura.Repositorio.IRepositorioPersonas;
import ficheros.EjercicioEstructura.Repositorio.RepositorioException;
import ficheros.EjercicioEstructura.Repositorio.RepositorioPersonasTxt;

public class ServicioPersonas implements IServicioPersonas{
	// LOGGER
    private static final Logger LOGGER = Logger.getLogger(ServicioPersonas.class.getName());
    
    // ATRIBUTOS
    public IRepositorioPersonas repositorio;

    // CONSTRUCTOR
    public ServicioPersonas(java.io.File fichero) {
        super();
        this.repositorio = new RepositorioPersonasTxt(fichero);
    }

    // MÉTODOS MENSAJES
    public void datoNoValido(String mensaje) {
        System.err.println("Dato no válido: " + mensaje);
        LOGGER.warning("Dato no válido: " + mensaje);
    }

    public void errorPersistencia(RepositorioException e) {
        System.err.println("Error de persistencia: " + e.getMessage());
        LOGGER.severe("Error de persistencia: " + e.getMessage());
    }

    // MÉTODOS DE LA INTERFAZ 
    
    @Override
    public List<Persona> listar() {
        List<Persona> resultado = new ArrayList<>();
        try {
            resultado = repositorio.findAll();
        } catch (RepositorioException e) {
            errorPersistencia(e);
        }
        return resultado;
    }

    @Override
    public Persona buscar(String nombre) {
        Persona resultado = null;
        try {
            resultado = repositorio.findById(nombre);
            if (resultado == null) {
                datoNoValido("No existe: " + nombre);
            }
        } catch (RepositorioException e) {
            errorPersistencia(e);
        }
        return resultado;
    }

    @Override
    public boolean alta(String nombre, List<Double> notas) {
        boolean hecho = false;
        try {
            if (repositorio.existsById(nombre)) {
                datoNoValido("Ya existe: " + nombre);
            } else {
                repositorio.save(new Persona(nombre, notas));
                hecho = true;
            }
        } catch (IllegalArgumentException e) {
            datoNoValido(e.getMessage());
        } catch (RepositorioException e) {
            errorPersistencia(e);
        }
        return hecho;
    }

    @Override
    public boolean modificarNotas(String nombre, List<Double> notas) {
        boolean hecho = false;
        try {
            if (!repositorio.existsById(nombre)) {
                datoNoValido("No existe: " + nombre);
            } else {
                repositorio.save(new Persona(nombre, notas));
                hecho = true;
            }
        } catch (IllegalArgumentException e) {
            datoNoValido(e.getMessage());
        } catch (RepositorioException e) {
            errorPersistencia(e);
        }
        return hecho;
    }

    @Override
    public boolean baja(String nombre) {
        boolean hecho = false;
        try {
            hecho = repositorio.deleteById(nombre);
            if (!hecho) {
                datoNoValido("No existe: " + nombre);
            }
        } catch (RepositorioException e) {
            errorPersistencia(e);
        }
        return hecho;
    }

    @Override
    public double media(Persona p) {
        double media = 0.0;
        if (p != null && p.getNotas() != null && !p.getNotas().isEmpty()) {
            double suma = 0.0;
            List<Double> notas = p.getNotas();
            
            int i = 0;
            while (i < notas.size()) {
                suma += notas.get(i);
                i++;
            }
            media = suma / notas.size();
        }
        return media;
    }
}
