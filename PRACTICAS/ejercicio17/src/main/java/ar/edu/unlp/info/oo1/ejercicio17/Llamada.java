package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDateTime;

public abstract class Llamada {
	private String telefonoEmisor;
	private String telefonoReceptor;
	private LocalDateTime fechaComienzo;
	private int duracion;
	
	public Llamada(String telefonoEmisor, String telefonoReceptor, LocalDateTime fechaComienzo, int duracion) {
		this.telefonoEmisor = telefonoEmisor;
		this.telefonoReceptor = telefonoReceptor;
		this.fechaComienzo = fechaComienzo;
		this.duracion = duracion;
	}
	
	public String getTelefonoEmisor() {
		return telefonoEmisor;
	}

	public String getTelefonoReceptor() {
		return telefonoReceptor;
	}

	public LocalDateTime getFechaComienzo() {
		return fechaComienzo;
	}

	public int getDuracion() {
		return duracion;
	}
	
	public boolean isInLapse(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		return this.fechaComienzo.isAfter(fechaInicio) || this.fechaComienzo.isBefore(fechaFin) || this.fechaComienzo.isEqual(fechaInicio) || this.fechaComienzo.isEqual(fechaFin);
 		
	}
	
	protected double calcularCosto(double price) {
		return this.duracion * price;
	}

	public abstract double calcularCosto();

}
