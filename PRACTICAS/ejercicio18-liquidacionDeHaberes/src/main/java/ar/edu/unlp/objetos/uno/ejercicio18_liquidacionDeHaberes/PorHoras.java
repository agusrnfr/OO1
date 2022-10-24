package ar.edu.unlp.objetos.uno.ejercicio18_liquidacionDeHaberes;

import java.time.LocalDate;

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

	@Override
	public boolean estaVencido() {
		return (this.fechaFin.isBefore(LocalDate.now()) || this.fechaFin.isEqual(LocalDate.now()));

	}

}
