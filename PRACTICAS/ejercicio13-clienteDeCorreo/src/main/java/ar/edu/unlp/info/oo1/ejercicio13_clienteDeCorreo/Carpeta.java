package ar.edu.unlp.info.oo1.ejercicio13_clienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
	private String nombre;
	private List<Email> emails;
	
	public Carpeta(String nombre) {
		this.nombre = nombre;
		this.emails = new ArrayList<Email>();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public List<Email> getEmails() {
		return emails;
	}
	
	public void agregarCorreo(Email email) {
		this.emails.add(email);
	}
	
	public void removerCorreo(Email email) {
		this.emails.remove(email);
	}
	
	public Email buscar (String texto) {
		return this.emails
				.stream()
				.filter(email -> email.contiene(texto))
				.findFirst().orElse(null);
	}
	
	public double espacioOcupado() {
		return this.emails
				.stream()
				.mapToDouble(email -> email.espacioOcupado())
				.sum();
	}
	
}
