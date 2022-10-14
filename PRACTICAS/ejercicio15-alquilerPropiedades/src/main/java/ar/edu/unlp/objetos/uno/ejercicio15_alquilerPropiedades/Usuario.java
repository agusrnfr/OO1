package ar.edu.unlp.objetos.uno.ejercicio15_alquilerPropiedades;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private String dni;
	private String direccion;
	private List<Reserva> reservas;
	private List<Propiedad> propiedades;
	
	public Usuario(String nombre, String direccion, String dni) {
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
		this.reservas = new ArrayList<Reserva>();
		this.propiedades = new ArrayList<Propiedad>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public List<Propiedad> getPropiedades() {
		return this.propiedades;
	}
	
	public List<Reserva> getReservas() {
		return this.reservas; 
	}
	
	public void agregarReserva (Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public void eliminarReserva (Reserva reserva){
		this.reservas.remove(reserva);
	}
	
	public void agregarPropiedad (Propiedad propiedad) {
		this.propiedades.add(propiedad);
	}
	
	public void eliminarPropiedad (Propiedad propiedad) {
		this.propiedades.remove(propiedad);
	}

	public double calcularIngresoPropietario (DateLapse periodo) {
		return this.propiedades.stream().mapToDouble(propiedad -> propiedad.calcularIngresoPropiedad(periodo)).sum();
	}
	

}
