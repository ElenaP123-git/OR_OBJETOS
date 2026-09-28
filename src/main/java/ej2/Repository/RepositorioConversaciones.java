package ej2.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator; // Importación correcta
import java.util.List;

import ej2.Exceptions.ConversacionException;
import ej2.Model.Conversacion;
import ej2.Model.TipoAgente;

public class RepositorioConversaciones implements IRepoConversaciones {
	
	// ATRIBUTOS
	private List<Conversacion> conversaciones; //era mejor un set
	
	// CONSTRUCTOR
	public RepositorioConversaciones() {
		this.conversaciones = new ArrayList<>();
	}
	
	// MÉTODOS DE INTERFAZ

	@Override
	public void agregaConversacion(TipoAgente tipo, String pregunta, String respuesta) {
		Conversacion nueva = new Conversacion(tipo, pregunta, respuesta);
		conversaciones.add(nueva);
	}

	@Override
	public Conversacion getConversacion(LocalDate fecha, TipoAgente tipo, String pregunta) throws ConversacionException {
		for (Conversacion c : conversaciones) {
			if (c.getFechaConversacion().equals(fecha) 
					&& c.getTipo() == tipo 
					&& c.getPregunta().equalsIgnoreCase(pregunta)) {
				return c; // Devuelve la primera coincidencia
			}
		}
		throw new ConversacionException("No se encontró ninguna conversación para la fecha, tipo y pregunta indicados.");
	}

	@Override
	public boolean contieneConversacion(Conversacion conversacion) {
		if (conversacion == null) return false;
		return conversaciones.contains(conversacion);
	}

	@Override
	public void eliminaConversacion(LocalDate fecha, TipoAgente tipo, String pregunta) throws ConversacionException {
	    boolean eliminado = false;

	    for (Conversacion c : conversaciones) {
	        if (!eliminado 
	                && c.getFechaConversacion().equals(fecha) 
	                && c.getTipo() == tipo 
	                && c.getPregunta().equalsIgnoreCase(pregunta)) {
	            
	            conversaciones.remove(c);
	            eliminado = true; // Marcamos que ya se eliminó
	        }
	    }

	    // Si terminó el bucle y no se encontró nada, lanzamos la excepción al final
	    if (!eliminado) {
	        throw new ConversacionException("No se pudo eliminar: No existe la conversación solicitada.");
	    }
	}

	@Override
	public void incrementaNumeroValoraciones(LocalDate fecha, TipoAgente tipo, String pregunta, double valoracion)
			throws ConversacionException {
		Conversacion conv = getConversacion(fecha, tipo, pregunta);
		conv.setNumValoracionesPositivas(conv.getNumValoracionesPositivas() + 1);
	}
}