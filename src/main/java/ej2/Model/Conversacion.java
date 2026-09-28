package ej2.Model;

import java.time.LocalDate;
import java.util.Objects;

public class Conversacion {

	//ATRIBUTOS
	private String identificador;
    private TipoAgente tipo;
    private String pregunta;
    private String respuesta;
    private LocalDate fechaConversacion;
    private int numValoracionesPositivas;
    
    //CONSTRUCTOR
    public Conversacion(TipoAgente tipo, String pregunta, String respuesta) {
		super();
		this.tipo = tipo;
		this.pregunta = pregunta;
		this.respuesta = respuesta;
	}
    
	 //GETTERS Y SETTERS
	public String getIdentificador() {
		return identificador;
	}

	
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public TipoAgente getTipo() {
		return tipo;
	}

	public void setTipo(TipoAgente tipo) {
		this.tipo = tipo;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public LocalDate getFechaConversacion() {
		return fechaConversacion;
	}

	public void setFechaConversacion(LocalDate fechaConversacion) {
		this.fechaConversacion = fechaConversacion;
	}

	public int getNumValoracionesPositivas() {
		return numValoracionesPositivas;
	}

	public void setNumValoracionesPositivas(int numValoracionesPositivas) {
		this.numValoracionesPositivas = numValoracionesPositivas;
	}

	//EQUALS Y HASHCODE
	@Override
	public int hashCode() {
		return Objects.hash(identificador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conversacion other = (Conversacion) obj;
		return Objects.equals(identificador, other.identificador);
	}

	//TOSTRING
	@Override
	public String toString() {
		return "Conversacion [identificador=" + identificador + ", tipo=" + tipo + ", pregunta=" + pregunta
				+ ", respuesta=" + respuesta + ", fechaConversacion=" + fechaConversacion
				+ ", numValoracionesPositivas=" + numValoracionesPositivas + "]";
	}
    
   
	
	
	
}
