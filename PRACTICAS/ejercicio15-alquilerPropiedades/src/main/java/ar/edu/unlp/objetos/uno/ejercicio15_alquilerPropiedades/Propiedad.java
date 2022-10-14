package ar.edu.unlp.objetos.uno.ejercicio15_alquilerPropiedades;

import java.util.ArrayList;
import java.util.List;

public class Propiedad {
	private String nombre;
	private String descripcion;
	private String direccion;
	private double precioPorNoche;
	private Usuario propietario;
	private List<Reserva> reservas;
	
	public Propiedad(String nombre, String descripcion, String direccion, double precioPorNoche, Usuario propietario) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.precioPorNoche = precioPorNoche;
		this.propietario = propietario;
		this.reservas = new ArrayList<Reserva>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public double getPrecioPorNoche() {
		return this.precioPorNoche;
	}
	
	public Usuario getPropietario() {
		return propietario;
	}
	
	public boolean disponibilidad (DateLapse periodo) {
		return this.reservas.stream().noneMatch(reserva -> reserva.overlaps(periodo));
	}
	
	public void agregarReserva (Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public void eliminarReserva (Reserva reserva){
		this.reservas.remove(reserva);
	}
	
	public double calcularIngresoPropiedad(DateLapse periodo) {
		return this.reservas.stream().mapToDouble(reserva -> reserva.calcularReserva()).sum();
		
	}
	
	public double calcularPrecio (int dias) {
		return dias * this.precioPorNoche;
	}

}
