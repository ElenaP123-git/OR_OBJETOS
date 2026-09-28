package ej3.Repository;

import ej3.Model.Cliente;
import ej3.Model.EnviadorSms;
import ej3.Model.INotificador;

public class NotificadorSms implements INotificador{
	
	//ATRIBUTOS
	private EnviadorSms enviadorSms;

	//CONSTRUCTOR
	public NotificadorSms() {
		this.enviadorSms = new EnviadorSms();
	}

	//MÉTODOS
	@Override
	public void notificar(Cliente cliente, String asunto, String mensaje) {
		String textoCompleto = asunto + " - " + mensaje;
        enviadorSms.enviarSms(cliente.getTelefono(), textoCompleto);
		
	}
	
	
}
