package JSON;

public class Domicilio {
	private String domicilio;
	private String calle;
	private int numero;
	private String ciudad;
	private String codigoPostal;
	
	public Domicilio(String domicilio, String calle, int numero, String ciudad, String codigoPostal) {
		super();
		this.domicilio = domicilio;
		this.calle = calle;
		this.numero = numero;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Override
	public String toString() {
		return "Domicilio [domicilio=" + domicilio + ", calle=" + calle + ", numero=" + numero + ", ciudad=" + ciudad
				+ ", codigoPostal=" + codigoPostal + "]";
	}
	
	
}
