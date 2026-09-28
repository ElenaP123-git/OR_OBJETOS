package ej3.Model;

import java.util.Objects;

public class Cliente {
	
	//ATRIBUTOS
	private String nombre;
    private String email;
    private String telefono;
    
    //CONSTRUCTOR
    public Cliente(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //EQUALS Y HASHCODE
    @Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(email, other.email);
	}

	//TOSTRING
    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + "]";
    }
}

