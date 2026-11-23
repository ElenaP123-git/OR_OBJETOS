package ficheros.XML.Empleados.Modelo;

import java.util.Objects;

public class Empleado {

	//ATRIBUTOS
	private String id;
	private String nombreApellidos;
	private int edad;
	private String empresa;
	private Puesto puesto;
	
	//CONSTRUCTOR
	public Empleado(String nombreApellidos, String empresa, Puesto puesto) {
		super();
		this.nombreApellidos = nombreApellidos;
		this.empresa = empresa;
		this.puesto = puesto;
	}

	//GETTERS Y SETTERS
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreApellidos() {
		return nombreApellidos;
	}

	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

	//toString
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombreApellidos=" + nombreApellidos + ", edad=" + edad + ", empresa=" + empresa
				+ ", puesto=" + puesto + "]";
	}

	//EQUALS Y HASHCODE
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(id, other.id);
	}
}
