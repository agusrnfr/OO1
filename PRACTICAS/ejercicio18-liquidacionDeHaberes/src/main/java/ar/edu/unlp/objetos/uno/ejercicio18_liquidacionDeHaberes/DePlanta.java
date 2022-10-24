package ar.edu.unlp.objetos.uno.ejercicio18_liquidacionDeHaberes;

import java.time.LocalDate;

public class DePlanta extends Contrato{
	private double sueldoMensual;
	private double montoPorConyugue;
	private double montoPorHijos;

	public DePlanta(Empleado empleado, LocalDate fechaInicio, double sueldoMensual, double montoPorConyugue, double montoPorHijos) {
		super(empleado, fechaInicio);
		this.sueldoMensual = sueldoMensual;
		this.montoPorConyugue = montoPorConyugue;
		this.montoPorHijos = montoPorHijos;
	}

	@Override
	public double calcularMonto() {
		double monto = this.sueldoMensual;
		if (this.getEmpleado().tieneConyugue()) {
			monto += this.montoPorConyugue;
		}
		
		if (this.getEmpleado().tieneHijos()) {
			monto += this.montoPorHijos;
		}
		return monto;
	}

	@Override
	public boolean estaVencido() {
		return false;
	}
}
