package ficheros.EXAMEN.Modelo;

import java.util.Objects;

import ficheros.EXAMEN.Repositorio.CriaturaFantasticasException;

/* CORREGIDO: Se añade implements Comparable<Criatura> para ordenar alfabéticamente por nombre en el TreeSet */
public class Criatura implements Comparable<Criatura> {

	private String nombre;
	private TipoCriatura tipo;
	private boolean inmortal;
	private int peligrosidad;
	private int magia;
	private Habitat habitat;
	
	/* CORREGIDO: Constructor completo asignando correctamente todos los atributos y validaciones */
	public Criatura(String nombre, TipoCriatura tipo, boolean inmortal, int peligrosidad, int magia, Habitat habitat) throws CriaturaFantasticasException {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.inmortal = inmortal;
		setPeligrosidad(peligrosidad); // Valida y asigna
		setMagia(magia);             // Valida y asigna
		this.habitat = habitat;
	}

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public TipoCriatura getTipo() { return tipo; }
	public void setTipo(TipoCriatura tipo) { this.tipo = tipo; }

	public boolean isInmortal() { return inmortal; }
	public void setInmortal(boolean inmortal) { this.inmortal = inmortal; }

	public int getPeligrosidad() { return peligrosidad; }
	public void setPeligrosidad(int peligrosidad) throws CriaturaFantasticasException{
		if (peligrosidad > 100 || peligrosidad < 0) {
			throw new CriaturaFantasticasException("La peligrosidad introducida es inválida");
		}
		this.peligrosidad = peligrosidad; /* CORREGIDO: Faltaba asignar el valor */
	}

	public int getMagia() { return magia; }
	public void setMagia(int magia) throws CriaturaFantasticasException{
		if(magia > 100 || magia < 0) {
			throw new CriaturaFantasticasException("El nivel de magia introducido es inválido");
		}
		this.magia = magia; /* CORREGIDO: Faltaba asignar el valor */
	}

	public Habitat getHabitat() { return habitat; }
	public void setHabitat(Habitat habitat) { this.habitat = habitat; }

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Criatura other = (Criatura) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Criatura [nombre=" + nombre + ", tipo=" + tipo + ", región=" + (habitat != null ? habitat.getRegion() : "N/A") + "]";
	}
	
	/* CORREGIDO:compareTo para orden natural alfabético por nombre (usado por el TreeSet) */
	@Override
	public int compareTo(Criatura c) {
		return this.nombre.compareToIgnoreCase(c.nombre);
	}
}
