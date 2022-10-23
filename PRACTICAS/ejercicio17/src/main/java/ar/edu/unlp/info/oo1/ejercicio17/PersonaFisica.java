package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDateTime;

public class PersonaFisica extends Persona{
	private String DNI;
	private String nroTelefono;

	public PersonaFisica(String nombre, String direccion, String DNI, String nroTelefono) {
		super(nombre, direccion, nroTelefono);
		this.DNI = DNI;
	}
	
	public double calcularMontoTotal(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		double monto = super.calcularMontoTotal(fechaInicio, fechaFin);
		return monto - monto * 0.1;
	}

}
