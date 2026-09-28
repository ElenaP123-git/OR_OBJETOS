package ej3.Model;

public class EnviadorEmail {

	public void enviarEmail(String direccion, String asunto, String cuerpo)
{		System.out.println("[EMAIL enviado a " + direccion + "]");
	    System.out.println("  Asunto: " + asunto);
	    System.out.println("  Cuerpo: " + cuerpo);
	    
		}
}
