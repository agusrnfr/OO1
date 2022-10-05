package ar.edu.unlp.info.oo1.ejercicio13_clienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {
	private Carpeta inbox;
	private List<Carpeta> carpetas;
	
	public ClienteDeCorreo(Carpeta inbox) {
		this.inbox = inbox;
		this.carpetas = new ArrayList<Carpeta>();
	}
	
	public Carpeta getInbox() {
		return inbox;
	}

	public List<Carpeta> getCarpetas() {
		return carpetas;
	}
	
	public void agregarCarpeta(Carpeta carpeta) {
		this.carpetas.add(carpeta);
	}
	
	public void recibir (Email email) {
		this.inbox.agregarCorreo(email);
	}
	
	public void mover (Email email, Carpeta origen, Carpeta destino) {
		destino.agregarCorreo(email);
		origen.removerCorreo(email);
	}

	public Email buscar(String texto){
		if (this.inbox.buscar(texto) != null){
			return this.inbox.buscar(texto);
		}
		return this.carpetas
				.stream()
				.map(carpeta -> carpeta.buscar(texto))
				.filter(email -> email != null)
				.findFirst().orElse(null);
	}
	
	public int espacioOcupado() {
		return (int) this.inbox.espacioOcupado() + (int) this.carpetas
				.stream()
				.mapToDouble(carpeta -> carpeta.espacioOcupado())
				.sum();
	}
	

}
