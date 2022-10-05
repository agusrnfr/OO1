package ar.edu.unlp.info.oo1.ejercicio13_clienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class Email {
	private String titulo;
	private String cuerpo;
	private List<Archivo> adjuntos;
	
	public Email(String titulo, String cuerpo) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.adjuntos = new ArrayList<Archivo>();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getCuerpo() {
		return cuerpo;
	}
	
	public void agregarAdjuntos (Archivo archivo) {
		this.adjuntos.add(archivo);
	}

	public List<Archivo> adjuntos() {
		return adjuntos;
	}
	
	public double espacioOcupado() {
		return (this.getTitulo().length() + this.getCuerpo().length() 
				+ this.adjuntos
				.stream()
				.mapToDouble(archivo -> archivo.tamaño())
				.sum());
	}
	
	public boolean contiene(String texto) {
		return this.getCuerpo().contains(texto) || this.getTitulo().contains(texto);
	}
	
}
