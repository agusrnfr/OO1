package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<String> numerosDisponibles;
	private List<Persona> clientes;
	
	
	public Sistema () {
		numerosDisponibles = new ArrayList<String>();
		clientes = new ArrayList<Persona>();
	}

	public void agregarNumero(String numero) {
		this.numerosDisponibles.add(numero);
		
	}
	
	private String getNumeroFinal() {
		String nro = this.numerosDisponibles.get(0);
		this.numerosDisponibles.remove(0);
		return nro;
	}
	
	public PersonaFisica agregarPersonaFisica(String nombre, String direccion, String DNI) {
		PersonaFisica persona = new PersonaFisica(nombre, direccion, DNI, this.getNumeroFinal());
		this.clientes.add(persona);
		return persona;
	}
	
	public PersonaJuridica agregarPersonaJuridica(String nombre, String direccion, String CUIT, String tipo) {
		PersonaJuridica persona = new PersonaJuridica(nombre, direccion, CUIT, tipo, this.getNumeroFinal());
		this.clientes.add(persona);
		return persona;
	}
	
	private Persona buscarEmisor (String nroEmisor) {
		return this.clientes.stream().filter(persona -> persona.getNroTelefono().equals(nroEmisor)).findFirst().orElse(null);
	}

	public LlamadaLocal registrarLlamadaLocal(LocalDateTime fecha, int duracion, String nroEmisor, String nroReceptor) {
		Persona persona = this.buscarEmisor(nroEmisor);
		return persona.registrarLlamadaLocal(fecha, duracion, nroEmisor, nroReceptor);
	}
	
	public LlamadaInterurbana registrarLlamadaInterurbana(LocalDateTime fecha, int duracion, String nroEmisor, String nroReceptor, double KM) {
		Persona persona = this.buscarEmisor(nroEmisor);
		return persona.registrarLlamadaInterurbana(fecha, duracion, nroEmisor, nroReceptor, KM);
	}
	
	public LlamadaInternacional registrarLlamadaInternacional(LocalDateTime fecha, int duracion, String nroEmisor, String nroReceptor, String paisDestino, String paisOrigen) {
		Persona persona = this.buscarEmisor(nroEmisor);
		return persona.registrarLlamadaInternacional(fecha, duracion, nroEmisor, nroReceptor, paisDestino, paisOrigen);
	}
	
	public Factura facturar (Persona cliente, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		return cliente.facturar(fechaInicio, fechaFin);
	}
	
}
