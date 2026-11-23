package ficheros.XML.Empleados.Modelo;

import java.util.Objects;

public class Puesto {

	//ATRIBUTOS
	private String id;
	private String nombre;
	private String departamento;
	private double salario;
	
	//CONSTRUCTOR
	public Puesto(String nombre, double salario) {
		super();
		this.nombre = nombre;
		this.salario = salario;
	}

	//GETTERS Y SETTERS
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	//toString
	@Override
	public String toString() {
		return "Puesto [id=" + id + ", nombre=" + nombre + ", departamento=" + departamento + ", salario=" + salario
				+ "]";
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
		Puesto other = (Puesto) obj;
		return Objects.equals(id, other.id);
	}
}
