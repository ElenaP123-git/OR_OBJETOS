package ej3.Repository;

import ej3.Model.Cliente;
import ej3.Model.EnviadorEmail;
import ej3.Model.INotificador;

public class NotificadorEmail implements INotificador{

	//ATRIBUTOS
	private EnviadorEmail enviadorEmail; //tiene que ser lista

	//CONSTRUCTOR
	public NotificadorEmail() {
		this.enviadorEmail = new EnviadorEmail();
	}

	//MÉTODOS
	@Override
	public void notificar (Cliente cliente, String asunto, String mensaje) {
		enviadorEmail.enviarEmail(cliente.getEmail(), asunto, mensaje);
		
	}
	
	
	
}
