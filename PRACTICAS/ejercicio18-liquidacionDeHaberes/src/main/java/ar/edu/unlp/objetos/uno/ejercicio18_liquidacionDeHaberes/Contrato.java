package ar.edu.unlp.objetos.uno.ejercicio18_liquidacionDeHaberes;

import java.time.LocalDate;

public abstract class Contrato {
	private Empleado empleado;
	private LocalDate fechaInicio;

	public Contrato(Empleado empleado, LocalDate fechaInicio) {
		this.empleado = empleado;
		this.fechaInicio = fechaInicio;
	}
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	
	public abstract boolean estaVencido();
	
	public abstract double calcularMonto();

	public Empleado getEmpleado() {
		return empleado;
	}

}
