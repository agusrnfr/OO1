package ar.edu.unlp.objetos.uno.ejercicio18_liquidacionDeHaberes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PorHoras extends Contrato {
	private LocalDate fechaFin;
	private double valorPorHora;
	private int horasPorMes;
	
	public PorHoras(Empleado empleado, LocalDate fechaInicio, LocalDate fechaFin, double valorPorHora, int horasPorMes) {
		super(empleado, fechaInicio);
		this.fechaFin = fechaFin;
		this.valorPorHora = valorPorHora;
		this.horasPorMes = horasPorMes;
	}
	
	@Override
	public double calcularMonto() {
		return valorPorHora * horasPorMes;
	}
	
	public int calcularAnios() {
		if (this.fechaFin.isBefore(LocalDate.now())) {
			return (int) this.getFechaInicio().until(this.fechaFin,ChronoUnit.YEARS);
		}
		return (int) this.getFechaInicio().until(LocalDate.now(), ChronoUnit.YEARS);
	}


	@Override
	public boolean estaVencido() {
		return (this.fechaFin.isBefore(LocalDate.now()) || this.fechaFin.isEqual(LocalDate.now()));

	}

}
