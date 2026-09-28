package ej3.Repository;

import ej3.Model.Cliente;
import ej3.Model.INotificador;

public class NotificadorWhatsApp implements INotificador{

	@Override
	public void notificar(Cliente cliente, String asunto, String mensaje) {
		System.out.println("[WHATSAPP enviado a " + cliente.getTelefono() + "]");
        System.out.println("  Mensaje: *" + asunto + "*\n  " + mensaje);
		
	}
	
}
